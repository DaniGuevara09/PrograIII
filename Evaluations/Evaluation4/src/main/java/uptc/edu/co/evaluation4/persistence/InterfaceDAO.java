package uptc.edu.co.evaluation4.persistence;

import java.util.List;

public interface InterfaceDAO<T> extends Cloneable{
    List<T> getAll();
    T findById(String id);
    T save( T object );
}
