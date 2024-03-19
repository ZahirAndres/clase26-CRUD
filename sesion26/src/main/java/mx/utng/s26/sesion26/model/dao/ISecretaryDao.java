package mx.utng.s26.sesion26.model.dao;
import java.util.List;
import mx.utng.s26.sesion26.model.entity.Secretary;

public interface ISecretaryDao {
    List<Secretary> list();
  void save(Secretary secretary);
  Secretary getById(Long id);
  void delete(Long id);
}
