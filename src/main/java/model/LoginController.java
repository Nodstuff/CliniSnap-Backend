package model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by tmeaney on 11/02/16.
 */
@RestController
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        UUID idOne = UUID.randomUUID();

        return idOne.toString();

    }

}
