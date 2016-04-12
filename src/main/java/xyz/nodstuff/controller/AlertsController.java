package xyz.nodstuff.controller;

import xyz.nodstuff.model.Alert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tmeaney on 04/03/16.
 */
@RestController
public class AlertsController {

    @RequestMapping("/alerts")
    public List<Alert> alerts(@RequestParam(value = "userId", defaultValue = "") String userId) {

        List<Alert> alerts = new ArrayList<>();

        alerts.add(new Alert("1","Dr. Jim Welsh","Dr. Jack Hanley","Are you in the library already?"));
        alerts.add(new Alert("2","Dr. Jack Hanley","Dr. Tom Meaney","Food?"));
        alerts.add(new Alert("3","Dr. Tom Meaney","Dr. Jim Welsh","What's the story pig?"));
        alerts.add(new Alert("4","Dr. Jack Hanley","Dr. Jim Welsh","What time are you coming in??"));
        alerts.add(new Alert("5","Dr. James Walsh","Dr. Tom Meaney","United are shit!"));

        return alerts;
    }
}
