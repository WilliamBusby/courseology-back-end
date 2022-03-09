package com.nology.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000/")
public class CourseController {

    @Autowired
    CourseRepository repository;

    @GetMapping("/course/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable String courseId) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.findById(Integer.parseInt(courseId)));
    }

    @PostMapping("/course")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        repository.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body("Added new course.");
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @DeleteMapping("/course/{courseId}")
    @Transactional
    public ResponseEntity<String> deleteCourse(@PathVariable String courseId) {
        repository.deleteById(Integer.parseInt(courseId));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Removed course.");
    }

    @GetMapping("/courses/{name}")
    public ResponseEntity<List<Course>> findAllByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.findAllByName('%' + name + '%'));
    }
}
