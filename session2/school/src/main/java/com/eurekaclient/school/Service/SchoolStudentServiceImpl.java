package com.eurekaclient.school.Service;

import com.eurekaclient.school.Entity.School;
import com.eurekaclient.school.Entity.Student;
import com.eurekaclient.school.Repository.SchoolRepository;
import com.eurekaclient.school.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SchoolStudentServiceImpl implements SchoolStudentService {
    private SchoolRepository schoolRepository;
    private StudentRepository studentRepository;

    @Autowired
    public SchoolStudentServiceImpl(SchoolRepository schoolRepository, StudentRepository studentRepository) {
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public Iterable<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School addSchool(School s) {
        return schoolRepository.save(s);
    }

    @Override
    public Optional<School> findById(Integer id) {
        return schoolRepository.findById(id);
    }

    @Override
    public List<Student> getStudentsBySchoolId(Integer schoolId) {
        Optional<School> school = schoolRepository.findById(schoolId);
        if(school.isPresent()){
            return school.get().getStudents();
        }
        return null;
    }


}
