package com.nology.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    Course findById(int id);

    String deleteById(int id);

    @Query(value = "SELECT * FROM course WHERE name LIKE ?1", nativeQuery = true)
    List<Course> findAllByName(String name);
}
