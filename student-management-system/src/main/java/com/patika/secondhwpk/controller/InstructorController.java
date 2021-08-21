package com.patika.secondhwpk.controller;

import com.patika.secondhwpk.model.Instructor;
import com.patika.secondhwpk.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class InstructorController {
    InstructorService _instructorService;

    //Dependency Inj işlemi tek parametre ile yapılıyorsa autowired annotationu kullanılmasa da olur
    @Autowired
    public InstructorController(InstructorService instructorService) {
        this._instructorService = instructorService;
    }

    //• Kullanıcı, tüm dersleri / eğitmenleri / öğrencilerin listesini sorgulayabilir
    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAll() {
        return new ResponseEntity<>(_instructorService.findAll(), HttpStatus.OK);
    }

    //• Kullanıcı, id bilgisini kullanarak herhangi bir ders / eğitmen / öğrenci bilgisini sorgulayabilir.
    @PostMapping("/instructors")
    public Instructor saveInstructor(@RequestBody Instructor instructor) {
        return _instructorService.save(instructor);
    }

    //• Kullanıcı, nesne bilgisini kullanarak herhangi bir ders / eğitmen / öğrenci bilgisini oluşturabilir/güncelleyebilir.
    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int id) {
        return new ResponseEntity<>(_instructorService.findById(id), HttpStatus.OK);
    }

    //• Kullanıcı, id bilgisini kullanarak herhangi bir ders / eğitmen / öğrenci bilgisini silebilir.
    @DeleteMapping("/instructors/{id}")
    public ResponseEntity deleteInstructorById(@PathVariable int id) {
        _instructorService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //• Kullanıcı, nesne bilgisini kullanarak herhangi bir ders / eğitmen / öğrenci bilgisini silebilir.
    @DeleteMapping("/instructors")
    public ResponseEntity deleteInstructor(@RequestBody Instructor instructor) {
        _instructorService.delete(instructor);
        return new ResponseEntity(HttpStatus.OK);
    }
}
