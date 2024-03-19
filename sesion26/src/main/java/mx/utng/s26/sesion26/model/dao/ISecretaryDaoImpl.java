package mx.utng.s26.sesion26.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.s26.sesion26.model.entity.Secretary;

@Repository
public class ISecretaryDaoImpl implements ISecretaryDao {
    @Autowired
private EntityManager em;


    @Override
    public List<Secretary> list() {
        
        return em.createQuery("from Secretary").getResultList();
    }
    @Override
    public void save(Secretary secretary) {
        if(secretary.getId()!= null && secretary.getId()>0){
            //Actualiza estudiantes
            em.merge(secretary);
        }else{
            em.persist(secretary);
        }
        
    }
    @Override
    public Secretary getById(Long id) {
        return em.find(Secretary.class, id);
    }
    @Override
    public void delete(Long id) {
        Secretary secretary = getById(id);
        em.remove(secretary);
    }
    
}
