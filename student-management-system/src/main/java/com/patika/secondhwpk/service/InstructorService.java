package com.patika.secondhwpk.service;

import com.patika.secondhwpk.dao.InstructorDAOJPAImpl;
import com.patika.secondhwpk.model.Instructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InstructorService implements BaseService<Instructor> {
    private InstructorDAOJPAImpl _instructorDAO;

    public InstructorService(InstructorDAOJPAImpl instructorDAO) {
        this._instructorDAO = instructorDAO;
    }

    @Override
    public List<Instructor> findAll() {
        return _instructorDAO.findAll();
    }

    @Override
    public Instructor findById(int id) {
        return (Instructor) _instructorDAO.findById(id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return (Instructor) _instructorDAO.save(instructor);
    }

    @Override
    public void deleteById(int id) {
        _instructorDAO.deleteById(id);
    }

    @Override
    public void delete(Instructor instructor) {
        _instructorDAO.delete(instructor);
    }
}
