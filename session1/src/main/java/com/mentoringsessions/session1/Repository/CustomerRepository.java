package com.mentoringsessions.session1.Repository;

import com.mentoringsessions.session1.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findById(String id);
    Optional<Customer> findByName(String name);
    Iterable<Customer> findAllBySalaryGreaterThanEqual(int compare);
    Integer deleteById(String id);

}
