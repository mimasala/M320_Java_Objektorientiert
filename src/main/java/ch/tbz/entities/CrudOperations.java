package ch.tbz.entities;

import java.util.List;

public interface CrudOperations<T,ID> {
    public List<T> getAll();
    public T get(ID id);
    public void save(T t);
    public void update(T t);
    public void delete(ID id);
}
