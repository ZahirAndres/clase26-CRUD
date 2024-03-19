package mx.utng.s26.sesion26.model.service;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 19/3/2024
 */
import java.util.List;

import mx.utng.s26.sesion26.model.entity.Teacher;

public interface ITeacherService {
    List<Teacher> list();
    void save(Teacher teacher);
    Teacher getByID(Long id);
    void delete(Long id);
}
