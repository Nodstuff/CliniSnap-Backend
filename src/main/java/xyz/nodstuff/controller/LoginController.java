package xyz.nodstuff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.nodstuff.interfaces.UserDAO;
import xyz.nodstuff.model.EncryptedToken;
import xyz.nodstuff.model.User;

import java.util.UUID;

/**
 * Created by tmeaney on 11/02/16.
 */
@RestController
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/login")
    public EncryptedToken login(@RequestBody User user) {
        UUID idOne = UUID.randomUUID();

        User currentUser = userDAO.findByUsername(user.getUsername());

        if(currentUser.getUserpword().equalsIgnoreCase(user.getUserpword())){

            currentUser.setAuthtoken(idOne.toString());

            userDAO.save(currentUser);

            return new EncryptedToken(idOne.toString());
        }
        else{

            return null;
        }

    }
}
