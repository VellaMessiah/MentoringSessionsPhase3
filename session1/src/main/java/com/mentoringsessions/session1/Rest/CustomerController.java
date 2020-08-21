package com.mentoringsessions.session1.Rest;

import com.mentoringsessions.session1.Entities.Customer;
import com.mentoringsessions.session1.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Customer>> getAllCustomer(){
        return new ResponseEntity<Iterable<Customer>>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> findById(@PathVariable String id){
        return new ResponseEntity<Optional<Customer>>(customerService.findById(id),HttpStatus.FOUND);

    }

    @GetMapping("/byname/{name}")
    public ResponseEntity<Optional<Customer>> findByName(@PathVariable String name){
        return new ResponseEntity<Optional<Customer>>(customerService.findByName(name),HttpStatus.FOUND);
    }

    @GetMapping("/bysalarygreater/{salary}")
    public ResponseEntity<Iterable<Customer>> findAllBySalaryGreaterThan(@PathVariable int salary){
        return new ResponseEntity<Iterable<Customer>>(customerService.findAllBySalaryGreaterThan(salary), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer c){
        return new ResponseEntity<Customer>(customerService.addCustomer(c),HttpStatus.OK);
    }

   @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id){
        Optional<Customer> c = customerService.deleteById(id);
        if(c.isPresent())
            return new ResponseEntity<Customer>(c.get(),HttpStatus.FOUND);
        else return ResponseEntity.status(HttpStatus.FOUND).body("No Such Customer");
   }

}
