package com.eurekaclient.school.Service;

import com.eurekaclient.school.Entity.School;
import com.eurekaclient.school.Entity.Student;

import java.util.List;
import java.util.Optional;

public interface SchoolStudentService {
    public Iterable<School> getAllSchools();
    public School addSchool(School s);
    public Optional<School> findById(Integer id);
    public List<Student> getStudentsBySchoolId(Integer schoolId);

}
