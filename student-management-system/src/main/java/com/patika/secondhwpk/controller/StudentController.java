package com.patika.secondhwpk.controller;

import com.patika.secondhwpk.model.Student;
import com.patika.secondhwpk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class StudentController {
    StudentService _studentService;

    //Dependency Inj işlemi tek parametre ile yapılıyorsa autowired annotationu kullanılmasa da olur
    @Autowired
    public StudentController(StudentService studentService) {
        this._studentService = studentService;
    }

    //• Kullanıcı, tüm dersleri / eğitmenleri / öğrencilerin listesini sorgulayabilir
    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity<>(_studentService.findAll(), HttpStatus.OK);
    }

    //• Kullanıcı, id bilgisini kullanarak herhangi bir ders / eğitmen / öğrenci bilgisini sorgulayabilir.
    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        return _studentService.save(student);
    }

    //• Kullanıcı, nesne bilgisini kullanarak herhangi bir ders / eğitmen / öğrenci bilgisini oluşturabilir/güncelleyebilir.
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable int id) {
        return new ResponseEntity<>(_studentService.findById(id), HttpStatus.OK);
    }

    //• Kullanıcı, id bilgisini kullanarak herhangi bir ders / eğitmen / öğrenci bilgisini silebilir.
    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteStudentById(@PathVariable int id) {
        _studentService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //• Kullanıcı, nesne bilgisini kullanarak herhangi bir ders / eğitmen / öğrenci bilgisini silebilir.
    @DeleteMapping("/students")
    public ResponseEntity deleteStudent(@RequestBody Student student) {
        _studentService.delete(student);
        return new ResponseEntity(HttpStatus.OK);
    }
}
