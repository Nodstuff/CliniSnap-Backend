package model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tmeaney on 11/02/16.
 */
@RestController
public class LoginController {

    private String username = "tom.meaney@mycit.ie";
    private String password = "helloworld";

    @RequestMapping("/login")
    public int patient(@RequestBody User user) {

        if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)){
            return 100;
        }
        else{
            return 0;
        }
    }

}
