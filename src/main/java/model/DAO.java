package model;

/**
 * Created by tmeaney on 22/03/16.
 */

public interface DAO {

    int save(Object o);

    void update(Object d);

    void delete(Object d);

    Object getWithId(int id, Class c);


}
