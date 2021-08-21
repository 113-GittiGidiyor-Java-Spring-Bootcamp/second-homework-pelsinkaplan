package com.patika.secondhwpk.service;

import com.patika.secondhwpk.dao.CourseDAOJPAImpl;
import com.patika.secondhwpk.model.Course;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseService implements BaseService<Course> {
    private CourseDAOJPAImpl _courseDAO;

    public CourseService(CourseDAOJPAImpl courseDAOJPA) {
        this._courseDAO = courseDAOJPA;
    }

    @Override
    public List<Course> findAll() {
        return _courseDAO.findAll();
    }

    @Override
    public Course findById(int id) {
        return (Course) _courseDAO.findById(id);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return (Course) _courseDAO.save(course);
    }

    @Override
    public void deleteById(int id) {
        _courseDAO.deleteById(id);
    }

    @Override
    public void delete(Course course) {
        _courseDAO.delete(course);
    }
}
