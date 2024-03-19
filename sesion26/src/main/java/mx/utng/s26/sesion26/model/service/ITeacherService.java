package mx.utng.s26.sesion26.model.service;

import java.util.List;

import mx.utng.s26.sesion26.model.entity.Teacher;

public interface ITeacherService {
    List<Teacher> list();
    void save(Teacher teacher);
    Teacher getByID(Long id);
    void delete(Long id);
}
