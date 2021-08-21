package com.patika.secondhwpk.dao;

import com.patika.secondhwpk.model.Course;
import com.patika.secondhwpk.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CourseDAOJPAImpl implements BaseDAO<Course> {
    private EntityManager _entityManager;

    @Autowired
    public CourseDAOJPAImpl(EntityManager entityManager) {
        this._entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        return _entityManager.createQuery("FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return _entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return _entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Course course = this.findById(id);
        _entityManager.remove(course);
    }

    @Override
    @Transactional
    public void delete(Course course) {
        _entityManager.remove(course);
    }
}
