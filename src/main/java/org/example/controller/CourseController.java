package org.example.controller;

import org.example.dto.Course;
import org.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<?> getCourseList(){
        List<Course> list = courseService.getCourseList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable("id") int id){
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course){
        List<Course> list =  courseService.addCourse(course);
        return ResponseEntity.ok(list);
    }

    @PutMapping
    public ResponseEntity<?> editCourse(@RequestBody Course course){
        List<Course> list = courseService.editCourse(course);
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") int id){
        List<Course> list = courseService.deletecourse(id);
        return ResponseEntity.ok(list);
    }
}
