package model;

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

        alerts.add(new Alert("1","James Walsh","Jack Hanley","Are you in the library already?"));
        alerts.add(new Alert("2","Jack Hanley","Tom Meaney","Food?"));
        alerts.add(new Alert("3","Tom Meaney","James Walsh","What's the story pig?"));
        alerts.add(new Alert("4","Jack Hanley","James Walsh","What time are you coming in??"));
        alerts.add(new Alert("5","James Walsh","Tom Meaney","United are shit!"));

        return alerts;
    }
}
