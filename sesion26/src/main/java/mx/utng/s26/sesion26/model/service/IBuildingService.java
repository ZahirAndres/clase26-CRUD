package mx.utng.s26.sesion26.model.service;

import java.util.List;

import mx.utng.s26.sesion26.model.entity.Building;

public interface IBuildingService {
    List<Building> list();
    void save(Building building);
    Building getByID(Long id);
    void delete(Long id);
}
