package xyz.nodstuff.interfaces;

import org.springframework.data.repository.CrudRepository;
import xyz.nodstuff.model.User;

/**
 * Created by tmeaney on 23/03/16.
 */
public interface UserDAO extends CrudRepository<User, Long> {

    /**
     * Return the user having the passed email or null if no user is found.
     *
     * @param username the user username.
     */
    User findByUsername(String username);

    User findByUser_Email(String user_email);

    User findById(int id);


}
