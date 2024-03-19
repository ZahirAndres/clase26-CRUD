package mx.utng.s26.sesion26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.s26.sesion26.model.dao.ISecretaryDao; 
import mx.utng.s26.sesion26.model.entity.Secretary;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 19/3/2024
 */
@Service
public class ISecretaryServiceImpl implements ISecretaryService{

    @Autowired
    private ISecretaryDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<Secretary> list() {
        return dao.list();
    }
    @Transactional
    @Override
    public void save(Secretary secretary) {
    dao.save(secretary);    
    }
    @Transactional(readOnly = true)
    @Override
    public Secretary getByID(Long id) {
        return dao.getById(id);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
    
}
