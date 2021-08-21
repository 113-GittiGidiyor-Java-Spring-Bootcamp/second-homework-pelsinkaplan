package com.patika.secondhwpk.service;

import com.patika.secondhwpk.dao.StudentDAOJPAImpl;
import com.patika.secondhwpk.model.Student;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService implements BaseService<Student> {
    private StudentDAOJPAImpl _studentDAO;

    public StudentService(StudentDAOJPAImpl studentDAO) {
        this._studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return _studentDAO.findAll();
    }

    @Override
    public Student findById(int id) {
        return (Student) _studentDAO.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return (Student) _studentDAO.save(student);
    }

    @Override
    public void deleteById(int id) {
        _studentDAO.deleteById(id);
    }

    @Override
    public void delete(Student student) {
        _studentDAO.delete(student);
    }
}
