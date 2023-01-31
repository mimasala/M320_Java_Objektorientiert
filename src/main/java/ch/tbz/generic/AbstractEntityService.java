package ch.tbz.generic;

import ch.tbz.exception.AbstractEntityNotFoundException;
import ch.tbz.util.JsonService;

import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import static ch.tbz.util.OsuLog.log;

public abstract class AbstractEntityService<T extends AbstractEntity> {
    private final AbstractEntityRepository<T> repository;
    private final Type type;
    private final JsonService jsonService;

    public AbstractEntityService(AbstractEntityRepository<T> repository, Type type) {
        this.repository = repository;
        this.type = type;
        this.jsonService = new JsonService();
    }

    public void create(AbstractEntity entity) {
        try {
            jsonService.fromJson(repository.save(createUUID(entity)), type);
        } catch (Exception e) {
            log(Level.SEVERE, e.getMessage());
        }
    }

    public void update(AbstractEntity entity) {
        try {
            jsonService.fromJson(repository.save(createUUID(entity)), type);
        } catch (Exception e) {
            log(Level.SEVERE, e.getMessage());
        }
    }

    public void deleteById(UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            log(Level.SEVERE, e.getMessage());
        }
    }

    public String findById(UUID id) {
        try {
            String entity = repository.findById(id);
            if (entity == null) {
                throw new AbstractEntityNotFoundException("Entity not found");
            }
            return entity;
        } catch (Exception e) {
            log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    public List<T> findAll() {
        try {
            String all = repository.findAll();
            if (all == null){
                throw new AbstractEntityNotFoundException("No entities found");
            }
            return jsonService.fromJsonList(all);
        } catch (Exception e) {
            log(Level.SEVERE, e.getMessage());
        }
        return null;
    }
    private AbstractEntity createUUID(AbstractEntity entity) {
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        }
        return entity;
    }
}
