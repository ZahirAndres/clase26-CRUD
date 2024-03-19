package mx.utng.s26.sesion26.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 19/3/2024
 */
import jakarta.persistence.EntityManager;
import mx.utng.s26.sesion26.model.entity.Student;

/**
 * Clase repositorio o dao. Guardar datos
 * anotaciones @repositorio
 */
@Repository
public class IStudentDaoImpl implements IStudentDao{

//Entity Manager y contexto de persistencia
//Guarda internamente todas las entidades y
//utiliza como una cache datos de DB
@Autowired
private EntityManager em;


    @Override
    public List<Student> list() {
        
        return em.createQuery("from Student").getResultList();
    }
    @Override
    public void save(Student student) {
        if(student.getId()!= null && student.getId()>0){
            //Actualiza estudiantes
            em.merge(student);
        }else{
            em.persist(student);
        }
        
    }
    @Override
    public Student getById(Long id) {
        return em.find(Student.class, id);
    }
    @Override
    public void delete(Long id) {
        Student student = getById(id);
        em.remove(student);
    }
    
}
