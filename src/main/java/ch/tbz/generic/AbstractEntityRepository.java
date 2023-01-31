package ch.tbz.generic;

import ch.tbz.util.API;
import ch.tbz.util.JsonService;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Getter@Setter
public abstract class AbstractEntityRepository<T extends AbstractEntity> {
    public API api;
    public JsonService jsonService = new JsonService();
    public AbstractEntityRepository(API api) {
        this.api = api;
    }
    public String save(AbstractEntity entityJson) throws IOException {
        return api.post("",jsonService.toJson(entityJson));
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