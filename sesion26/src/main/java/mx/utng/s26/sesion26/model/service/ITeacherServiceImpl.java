package mx.utng.s26.sesion26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.s26.sesion26.model.dao.ITeacherDao; 
import mx.utng.s26.sesion26.model.entity.Teacher;
/*
 * Una clase service, esta basada en el patron del diseño fachada
 * Es un unico punto de acceso hacia los DAOs (data acces object). Dentro de la clase
 * service podemo operar con distintas clases DAO
 */
@Service
public class ITeacherServiceImpl implements ITeacherService{

//Inyectamos la interfaz para utilizar los métodos de CRUD
//C-create, R-read-retrieve, U-update, D-delete
    @Autowired
    private ITeacherDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<Teacher> list() {
        return dao.list();
    }
    @Transactional
    @Override
    public void save(Teacher teacher) {
    dao.save(teacher);    
    }
    @Transactional(readOnly = true)
    @Override
    public Teacher getByID(Long id) {
        return dao.getById(id);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
    
}
