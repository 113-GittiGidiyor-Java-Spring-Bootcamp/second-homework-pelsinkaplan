package com.patika.secondhwpk.dao;

import com.patika.secondhwpk.model.Course;
import com.patika.secondhwpk.model.Instructor;
import com.patika.secondhwpk.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class InstructorDAOJPAImpl implements BaseDAO<Instructor> {
    private EntityManager _entityManager;

    @Autowired
    public InstructorDAOJPAImpl(EntityManager entityManager) {
        this._entityManager = entityManager;
    }


    @Override
    public List<Instructor> findAll() {
        return _entityManager.createQuery("FROM Instructor s", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int id) {
        return _entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return _entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Instructor instructor = this.findById(id);
        _entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void delete(Instructor instructor) {
        _entityManager.remove(instructor);
    }
}
