package com.eurekaclient.school.Controller;

import com.eurekaclient.school.Entity.School;
import com.eurekaclient.school.Entity.Student;
import com.eurekaclient.school.Service.SchoolStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SchoolStudentController {
    SchoolStudentService schoolStudentService;

    @Autowired
    public SchoolStudentController(SchoolStudentService schoolStudentService) {
        this.schoolStudentService = schoolStudentService;
    }

    @PostMapping("/school/add")
    public ResponseEntity<School> addSchool(@RequestBody School s){
        return new ResponseEntity<School>(schoolStudentService.addSchool(s), HttpStatus.OK);
    }

    @GetMapping("/school/all/{id}")
    public ResponseEntity<?> findAllStudentsBySchoolId(@PathVariable Integer id){
        List<Student> studentList = schoolStudentService.getStudentsBySchoolId(id);
        if(studentList==null)
            return new ResponseEntity<String> ("No such School",HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<Student>>(studentList,HttpStatus.OK);
    }

    @GetMapping("/school/{id}")
    public ResponseEntity<?> findSchoolBySchoolId(@PathVariable Integer id){
        Optional<School> school = schoolStudentService.findById(id);
        if(school.isPresent()==false)
            return new ResponseEntity<String> ("No such School",HttpStatus.NOT_FOUND);
        return new ResponseEntity<School>(school.get(),HttpStatus.OK);
    }
}
