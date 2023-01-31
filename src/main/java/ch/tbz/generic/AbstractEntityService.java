package ch.tbz.generic;

import ch.tbz.util.JsonService;
import ch.tbz.util.OsuLog;

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

    public T create(String entity) {
        try {
            return jsonService.fromJson(repository.save(entity), type);
        } catch (Exception e) {
            log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    public T update(String entity) {
        try {
            return jsonService.fromJson(repository.save(entity), type);
        } catch (Exception e) {
            log(Level.SEVERE, e.getMessage());
        }
        return null;
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
            return repository.findById(id);
        } catch (Exception e) {
            log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    public List<T> findAll() {
        try {
            return jsonService.fromJsonList(repository.findAll());
        } catch (Exception e) {
            log(Level.SEVERE, e.getMessage());
        }
        return null;
    }
}
