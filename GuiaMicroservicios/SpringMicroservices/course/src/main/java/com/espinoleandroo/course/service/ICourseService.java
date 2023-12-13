package com.espinoleandroo.course.service;

import com.espinoleandroo.course.entities.Course;
import com.espinoleandroo.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {

    List<Course> findAll();

    Course findById(Long id);

    void save(Course course);

    StudentByCourseResponse findStudentsByIdCourse(Long idCourse);
}
