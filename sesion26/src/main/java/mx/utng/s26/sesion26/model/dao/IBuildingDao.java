package mx.utng.s26.sesion26.model.dao;
import java.util.List;
import mx.utng.s26.sesion26.model.entity.Building;

public interface IBuildingDao {
    List<Building> list();
  void save(Building building);
  Building getById(Long id);
  void delete(Long id);
}
