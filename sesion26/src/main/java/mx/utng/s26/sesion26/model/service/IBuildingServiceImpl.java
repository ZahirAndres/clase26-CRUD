package mx.utng.s26.sesion26.model.service;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 19/3/2024
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.s26.sesion26.model.dao.IBuildingDao; 
import mx.utng.s26.sesion26.model.entity.Building;

@Service
public class IBuildingServiceImpl implements IBuildingService{

    @Autowired
    private IBuildingDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<Building> list() {
        return dao.list();
    }
    @Transactional
    @Override
    public void save(Building building) {
    dao.save(building);    
    }
    @Transactional(readOnly = true)
    @Override
    public Building getByID(Long id) {
        return dao.getById(id);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
    
}
