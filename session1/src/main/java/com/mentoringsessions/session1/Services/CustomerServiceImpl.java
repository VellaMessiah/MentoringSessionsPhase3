package com.mentoringsessions.session1.Services;

import com.mentoringsessions.session1.Entities.Customer;
import com.mentoringsessions.session1.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }


    @Override
    public Iterable<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }


    @Override
    public Customer addCustomer(Customer c) {
        return customerRepository.save(c);
    }


    @Override
    public Optional<Customer> findById(String customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Optional<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Iterable<Customer> findAllBySalaryGreaterThan(int compare) {
        return customerRepository.findAllBySalaryGreaterThanEqual(compare);
    }

    @Override
    public Optional<Customer> deleteById(String id) {
        Optional<Customer> c = customerRepository.findById(id);
        if(c.isPresent()){
            customerRepository.deleteById(c.get().getId());
        }
        return c;
    }


}
