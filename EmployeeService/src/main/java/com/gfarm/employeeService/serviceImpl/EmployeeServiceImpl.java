package com.gfarm.employeeService.serviceImpl;

import com.gfarm.employeeService.entities.Employee;
import com.gfarm.employeeService.feignClient.AddressClient;
import com.gfarm.employeeService.repository.EmployeeRepo;
import com.gfarm.employeeService.response.AddressReps;
import com.gfarm.employeeService.response.EmployeeResponse;
import com.gfarm.employeeService.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressClient addressClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

//    public EmployeeServiceImpl(RestTemplateBuilder builder) {
//        this.restTemplate = builder.build();
//    }

//    @Autowired
//    private WebClient webClient;

    @Override
    public EmployeeResponse getEmployeeById(Integer id) {

        AddressReps addressReps = new AddressReps();
        Employee employee = employeeRepo.findById(id).get();
        EmployeeResponse employeeResponse= modelMapper.map(employee , EmployeeResponse.class);

        //restTemplate
        //addressReps = restTemplate.getForObject("http://localhost:8080/address/add/1" , AddressReps.class);

        //webClient
//        addressReps = webClient.get()
//                .uri("http://localhost:8080/address/add/1")
//                .retrieve()
//                .bodyToMono(AddressReps.class)
//                .block();

        //openFeign
         addressReps = addressClient.getAddressById();

        //DiscoveryClient
//        List<ServiceInstance> instances = discoveryClient.getInstances("AdressService");
//        ServiceInstance serviceInstance = instances.get(0);
//        String uri = serviceInstance.getUri().toString();
//        System.out.println("uri----> "+uri);
//        addressReps = restTemplate.getForObject(uri +"/address/add/1" , AddressReps.class);

        //LoadBalancerClient
//        ServiceInstance instances = loadBalancerClient.choose("AdressService");
//        String uri = instances.getUri().toString();
//        System.out.println("uri----> "+uri);
//        addressReps = restTemplate.getForObject(uri +"/address/add/1" , AddressReps.class);

        //direct service call for eureka
       // addressReps = restTemplate.getForObject("http://ADRESSSERVICE/address/add/1" , AddressReps.class);

        employeeResponse.setAddressReps(addressReps);
        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return List.of();
    }

    @Override
    public EmployeeResponse ceateEmployee(EmployeeResponse emp) {

       Employee employee = modelMapper.map(emp , Employee.class);
        employee = employeeRepo.save(employee);
        EmployeeResponse employeeResponse = modelMapper.map(employee , EmployeeResponse.class);

        return employeeResponse;
    }
}
