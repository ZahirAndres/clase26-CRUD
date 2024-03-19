package mx.utng.s26.sesion26.model.dao;
import java.util.List;
import mx.utng.s26.sesion26.model.entity.Secretary;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 19/3/2024
 */
public interface ISecretaryDao {
    List<Secretary> list();
  void save(Secretary secretary);
  Secretary getById(Long id);
  void delete(Long id);
}
