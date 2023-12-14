package com.espinoleandroo.course.client;

import com.espinoleandroo.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "localhost:8080/api/student/")
public interface StudentClient {

    @GetMapping("/search-by-course/{idCourse}")
    List<StudentDTO> findAllStudentsByCourse(@PathVariable Long idCourse);

}
