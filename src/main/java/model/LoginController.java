package model;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tmeaney on 11/02/16.
 */
@EnableOAuth2Sso
@RestController
public class LoginController {

    @RequestMapping("/login")
    public void patient() {
        
    }

}
