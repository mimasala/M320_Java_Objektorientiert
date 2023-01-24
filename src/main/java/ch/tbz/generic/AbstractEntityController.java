package ch.tbz.generic;

import java.util.List;
import java.util.UUID;

public abstract class AbstractEntityController<T extends AbstractEntity> {
    private final AbstractEntityService<T> service;

    public AbstractEntityController(AbstractEntityService<T> service) {
        this.service = service;
    }

    public T create(T entity) {
        return service.create(entity);
    }

    public T update(T entity) {
        return service.update(entity);
    }

    public void delete(T entity) {
        service.delete(entity);
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
