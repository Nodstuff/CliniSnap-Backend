package model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tmeaney on 11/02/16.
 */
@RestController
public class LoginController {

    private String username = "tom.meaney@mycit.ie:alice.muller.67@gmail.com";
    private String password = "helloworld:unicorns";

    @RequestMapping("/login")
    public User patient(@RequestBody User user) {

        if(user.getUsername().contains(username) && user.getPassword().contains(password)){
            user.setAccess(1);
        }
        else{
            return user;
        }

        return user;

    }

}
