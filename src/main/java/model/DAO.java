package model;

/**
 * Created by tmeaney on 22/03/16.
 */


/**
 * Created by nodstuff on 13/10/15.
 */
public interface DAO {

    int save(Object o);

    void update(Object d);

    void delete(Object d);

    Object getWithId(int id, Class c);


}
