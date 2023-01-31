package ch.tbz.generic;


import java.util.List;
import java.util.UUID;
/**
 * Abstract Entity Controller
 * @author mytal
 * @version 1.0.0
 */
public abstract class AbstractEntityController<T extends AbstractEntity> {
    private final AbstractEntityService<T> service;

    public AbstractEntityController(AbstractEntityService<T> service) {
        this.service = service;
    }

    public void create(AbstractEntity entity) {
        service.create(entity);
    }

    public void update(AbstractEntity entity) {
        service.update(entity);
    }

    public void deleteById(UUID id) {
        service.deleteById(id);
    }

    public String findById(UUID id) {
        return service.findById(id);
    }

    public List<T> findAll() {
        return service.findAll();
    }
}
