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
import mx.utng.s26.sesion26.model.dao.IStudentDao; 
import mx.utng.s26.sesion26.model.entity.Student;
/*
 * Una clase service, esta basada en el patron del diseño fachada
 * Es un unico punto de acceso hacia los DAOs (data acces object). Dentro de la clase
 * service podemo operar con distintas clases DAO
 */
@Service
public class IStudentServiceImpl implements IStudentService{

//Inyectamos la interfaz para utilizar los métodos de CRUD
//C-create, R-read-retrieve, U-update, D-delete
    @Autowired
    private IStudentDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<Student> list() {
        return dao.list();
    }
    @Transactional
    @Override
    public void save(Student student) {
    dao.save(student);    
    }
    @Transactional(readOnly = true)
    @Override
    public Student getByID(Long id) {
        return dao.getById(id);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
    
}
