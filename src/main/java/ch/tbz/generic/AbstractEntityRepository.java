package ch.tbz.generic;

import ch.tbz.util.API;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Getter@Setter
public abstract class AbstractEntityRepository<T extends AbstractEntity> {
    public API api;
    public AbstractEntityRepository(API api) {
        this.api = api;
    }
    public String save(String entityJson) throws IOException {
        return api.post("",entityJson);
    }

    public void deleteById(UUID id) throws IOException {
        api.delete(id.toString());
    }

    public String findById(UUID id) throws IOException {
        return api.get("/"+id.toString());
    }

    public String findAll() throws IOException {
        return api.get("");
    }
}