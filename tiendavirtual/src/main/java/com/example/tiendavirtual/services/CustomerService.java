package com.example.tiendavirtual.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.tiendavirtual.entities.CustomerEntity;
import com.example.tiendavirtual.mappers.CustomerMapper;
import com.example.tiendavirtual.models.Customer;
import com.example.tiendavirtual.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service 
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    
    public List<Customer> getAllCustomers(){
        List<CustomerEntity> customersEntity = customerRepository.getAllCustomerEntity();
        List<Customer> customers = customersEntity.stream().map(CustomerMapper::entityToModel).toList();
        return customers;
    }

   public Customer getByIdentification(String identification){
    CustomerEntity customerEntity = customerRepository.getByIdentification(identification);
    if (customerEntity == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
    }
    Customer customer = CustomerMapper.entityToModel(customerEntity);
    return customer;
}

    public Customer create(Customer customer){
        CustomerEntity customerEntity = CustomerMapper.modelToEntity(customer);
        CustomerEntity createCustomerEntity = customerRepository.create(customerEntity);
        Customer createCustomer = CustomerMapper.entityToModel(createCustomerEntity);
        return createCustomer;
    }

    public Customer update(UUID id, Customer customer){
        CustomerEntity customerEntityExist = customerRepository.getById(id);
        Customer customerExist = CustomerMapper.entityToModel(customerEntityExist);
        customerExist.setName(customer.getName());
        customerExist.setIdentification(customer.getIdentification());
        customerExist.setEmail(customer.getEmail());
        customerExist.setAddress(customer.getAddress());
        CustomerEntity customerEntity = CustomerMapper.modelToEntity(customerExist);
        CustomerEntity customerEntityUpdate = customerRepository.update(customerEntity);
        Customer customerUpdate = CustomerMapper.entityToModel(customerEntityUpdate);
        return customerUpdate;
    }

    public void delete(UUID id){
        CustomerEntity customerEntity= customerRepository.getById(id);
        customerRepository.delete(customerEntity);
    }

}
