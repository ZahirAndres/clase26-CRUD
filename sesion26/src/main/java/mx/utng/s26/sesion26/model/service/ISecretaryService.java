package mx.utng.s26.sesion26.model.service;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 19/3/2024
 */
import java.util.List;

import mx.utng.s26.sesion26.model.entity.Secretary;

public interface ISecretaryService {
    List<Secretary> list();
    void save(Secretary secretary);
    Secretary getByID(Long id);
    void delete(Long id);
}
