package mx.utng.s26.sesion26.model.service;

import java.util.List;

import mx.utng.s26.sesion26.model.entity.Student;

public interface IStudentService {
    List<Student> list();
    void save(Student student);
    Student getByID(Long id);
    void delete(Long id);
}
