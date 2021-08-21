package com.patika.secondhwpk.dao;

import com.patika.secondhwpk.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentDAOJPAImpl implements BaseDAO<Student> {
    private EntityManager _entityManager;

    @Autowired
    public StudentDAOJPAImpl(EntityManager entityManager) {
        this._entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        return _entityManager.createQuery("FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return _entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return _entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Student student = this.findById(id);
        _entityManager.remove(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        _entityManager.remove(student);
    }
}
