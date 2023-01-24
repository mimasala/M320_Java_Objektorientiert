package ch.tbz.generic;

import ch.tbz.util.JsonService;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import static ch.tbz.Main.api;
import static ch.tbz.util.OsuLog.log;

public abstract class AbstractEntityRepository<T extends AbstractEntity> {
    JsonService<T> jsonService = new JsonService<>();
    public T save(T entity) {
        try {
            api.post("/", jsonService.write(entity));
        } catch (IOException e) {
            log(Level.SEVERE, e.getMessage());
        }
        return entity;
    }

    public void delete(T entity) {
        try {
            api.delete(entity.getId().toString());
        } catch (IOException e) {
            log(Level.SEVERE, e.getMessage());
        }
    }

    public void deleteById(UUID id) {
        try {
            api.delete(id.toString());
        } catch (IOException e) {
            log(Level.SEVERE, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public T findById(UUID id) {
        try {
            return jsonService.read(api.get(id.toString()), (Class<T>) this.getClass().getGenericSuperclass());
        } catch (IOException e) {
            log(Level.SEVERE, "Could not find " + this.getClass().getSimpleName() + " with id " + id);
            log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    public List<T> findAll() {
//        try {
//            return jsonService.readList(api.get(""));
//        } catch (IOException e) {
//            log(Level.SEVERE, e.getMessage());
//        }
        return null;
    }
}