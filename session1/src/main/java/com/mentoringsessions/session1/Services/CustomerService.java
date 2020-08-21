package com.mentoringsessions.session1.Services;

import com.mentoringsessions.session1.Entities.Customer;

import java.util.Optional;


public interface CustomerService {
    public Iterable<Customer> getAllCustomer();
    public Customer addCustomer(Customer c);
    public Optional<Customer> findById(String customerId);
    public Optional<Customer> findByName(String name);
    public Iterable<Customer> findAllBySalaryGreaterThan(int compare);
    Optional<Customer> deleteById(String id);
}
