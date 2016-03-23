package xyz.nodstuff.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.nodstuff.gcm.GcmSender;

/**
 * Created by tmeaney on 07/03/16.
 */
@RestController
public class TokenController {

    @RequestMapping("/token")
    public void saveToken(@RequestParam(value = "token", defaultValue = "") String token){
       // List<String> tokenList = new ArrayList<>();

        //Todo add token to database here and store under user ID
        GcmSender g = new GcmSender();
        g.sendMessage("Hello, World!",token);
    }
}