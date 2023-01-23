package ch.tbz.generic;

import java.util.List;
import java.util.UUID;

public abstract class AbstractEntityRepository<T extends AbstractEntity> {
    public T save(T entity){
        //TODO : implement
        System.out.println("save");
        return null;
    }

    public void delete(T entity) {
        System.out.println("delete");
        //TODO : implement
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
        System.out.println("findAll");
        //TODO : implement
        return null;
    }
}