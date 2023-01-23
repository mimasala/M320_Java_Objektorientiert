package ch.tbz.generic;

import java.util.List;
import java.util.UUID;

public abstract class AbstractEntityService<T extends AbstractEntity> {
    private final AbstractEntityRepository<T> repository;

    public AbstractEntityService(AbstractEntityRepository<T> repository) {
        this.repository = repository;
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public T update(T entity) {
        return repository.save(entity);
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public T findById(UUID id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }
}
