package mx.utng.s26.sesion26.model.dao;
import java.util.List;
import mx.utng.s26.sesion26.model.entity.Teacher;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 19/3/2024
 */
public interface ITeacherDao {
    List<Teacher> list();
  void save(Teacher teacher);
  Teacher getById(Long id);
  void delete(Long id);
}
