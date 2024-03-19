package mx.utng.s26.sesion26.model.service;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 19/3/2024
 */
import java.util.List;

import mx.utng.s26.sesion26.model.entity.Building;

public interface IBuildingService {
    List<Building> list();
    void save(Building building);
    Building getByID(Long id);
    void delete(Long id);
}
