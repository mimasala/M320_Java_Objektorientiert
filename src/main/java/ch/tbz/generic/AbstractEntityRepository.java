package ch.tbz.generic;

import ch.tbz.util.JsonService;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.logging.Level;

import static ch.tbz.Main.api;
import static ch.tbz.util.OsuLog.log;

public abstract class AbstractEntityRepository<T extends AbstractEntity> {
    {
        api.setEntityPrefix(this.getClass()
                .getSimpleName()
                .toLowerCase(Locale.ROOT));
    }
    JsonService<T> jsonService = new JsonService<>();
    public T save(T entity) {
        try {
            String response = api.post("/", jsonService.write(entity));
            log(Level.INFO, "Saved entity: " + response);
        } catch (IOException e) {
            log(Level.SEVERE,e.getMessage());
        }
        return null;
    }

    public void delete(T entity) {
        try {
            String response = api.post("/", jsonService.write(entity));
            log(Level.INFO, "Deleted entity: " + response);
        } catch (IOException e) {
            log(Level.SEVERE,e.getMessage());
        }
    }

    public void deleteById(UUID id) {
        System.out.println("deleteById");
        //TODO : implement
    }

    public T findById(UUID id) {
        System.out.println("findById");
        //TODO : implement
        return null;
    }

    public List<T> findAll() {
        return null;
    }
}