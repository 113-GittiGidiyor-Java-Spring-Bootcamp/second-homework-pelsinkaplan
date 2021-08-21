package com.patika.secondhwpk.controller;

import com.patika.secondhwpk.model.Course;
import com.patika.secondhwpk.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class CourseController {
    CourseService _courseService;

    //Dependency Inj işlemi tek parametre ile yapılıyorsa autowired annotationu kullanılmasa da olur
    @Autowired
    public CourseController(CourseService courseService) {
        this._courseService = courseService;
    }

    //• Kullanıcı, tüm dersleri / eğitmenleri / öğrencilerin listesini sorgulayabilir
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAll() {
        return new ResponseEntity<>(_courseService.findAll(), HttpStatus.OK);
    }

    //• Kullanıcı, id bilgisini kullanarak herhangi bir ders / eğitmen / öğrenci bilgisini sorgulayabilir.
    @PostMapping("/courses")
    public Course saveCourse(@RequestBody Course course) {
        return _courseService.save(course);
    }

    //• Kullanıcı, nesne bilgisini kullanarak herhangi bir ders / eğitmen / öğrenci bilgisini oluşturabilir/güncelleyebilir.
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable int id) {
        return new ResponseEntity<>(_courseService.findById(id), HttpStatus.OK);
    }

    //• Kullanıcı, id bilgisini kullanarak herhangi bir ders / eğitmen / öğrenci bilgisini silebilir.
    @DeleteMapping("/courses/{id}")
    public ResponseEntity deleteCourseById(@PathVariable int id) {
        _courseService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //• Kullanıcı, nesne bilgisini kullanarak herhangi bir ders / eğitmen / öğrenci bilgisini silebilir.
    @DeleteMapping("/courses")
    public ResponseEntity deleteCourse(@RequestBody Course course) {
        _courseService.delete(course);
        return new ResponseEntity(HttpStatus.OK);
    }
}
