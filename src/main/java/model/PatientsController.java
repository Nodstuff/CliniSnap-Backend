package model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tmeaney on 11/02/16.
 */
@RestController
public class PatientsController {

        @RequestMapping("/patient")
        public Patient patient(@RequestParam(value="name", defaultValue="World") String name) {
            return new Patient("999999000000","Tom","Meaney",30,"29 Friars Walk","Ballyphehane","Cork City");
        }



}
