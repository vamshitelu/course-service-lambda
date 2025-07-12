package org.example.service;

import org.example.dto.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    public List<Course> getCourseList(){
        return courseList;
    }

    public Course getCourseById(int id){
        return courseList.stream().filter(course -> course.getId()==id).findFirst().get();
    }

    public List<Course> addCourse(Course course){
        courseList.add(course);
        return courseList;
    }

    public List<Course> editCourse(Course course){
        courseList.stream().filter(c -> c.getId() == course.getId())
                .findFirst().ifPresent(c -> {
                    c.setName(course.getName());
                    c.setPrice(course.getPrice());
                });
        return courseList;
    }

    public List<Course> deletecourse(int id){
        courseList.removeIf(c -> c.getId() == id);
        return courseList;
    }
}
