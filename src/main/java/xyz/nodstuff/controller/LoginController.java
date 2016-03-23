package xyz.nodstuff.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.nodstuff.interfaces.UserDAO;
import xyz.nodstuff.model.EncryptedToken;
import xyz.nodstuff.model.User;

import javax.sql.DataSource;
import java.util.UUID;

/**
 * Created by tmeaney on 11/02/16.
 */
@RestController
@Slf4j(topic = "DB")
public class LoginController {

    @Autowired
    private DataSource datasource;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/login")
    public EncryptedToken login(@RequestBody User user) {
        UUID idOne = UUID.randomUUID();

        User currentUser = userDAO.findByUsername(user.getUsername());

        currentUser.setAuthtoken(idOne.toString());

        userDAO.save(currentUser);

        return new EncryptedToken(idOne.toString());
    }
}
