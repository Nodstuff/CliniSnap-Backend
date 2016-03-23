package xyz.nodstuff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.nodstuff.gcm.GcmSender;
import xyz.nodstuff.interfaces.UserDAO;
import xyz.nodstuff.model.User;

/**
 * Created by tmeaney on 07/03/16.
 */
@RestController
public class TokenController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/token")
    public void saveToken(@RequestParam(value = "token", defaultValue = "") String token, @RequestParam(value = "authToken") String authToken){

        User user = userDAO.findByAuthtoken(authToken);

        user.setPushtoken(token);

        userDAO.save(user);

        //Todo add token to database here and store under user ID
        GcmSender sender = new GcmSender();
        sender.sendMessage("Hello, World!",user.getPushtoken());
    }
}
