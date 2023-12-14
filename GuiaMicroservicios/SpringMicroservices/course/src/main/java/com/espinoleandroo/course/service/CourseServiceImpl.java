package com.espinoleandroo.course.service;

import com.espinoleandroo.course.client.StudentClient;
import com.espinoleandroo.course.dto.StudentDTO;
import com.espinoleandroo.course.entities.Course;
import com.espinoleandroo.course.http.response.StudentByCourseResponse;
import com.espinoleandroo.course.persistence.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseRepository iCourseRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) iCourseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return iCourseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        iCourseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {

        Course course = iCourseRepository.findById(idCourse).orElse(new Course());

        List<StudentDTO> studentDTOList = studentClient.findAllStudentsByCourse(idCourse);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentList(studentDTOList)
                .build();
    }
}
