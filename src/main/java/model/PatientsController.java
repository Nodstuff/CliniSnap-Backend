package model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tmeaney on 11/02/16.
 */
@RestController
public class PatientsController {

    @RequestMapping("/patient")
    public Patient patient(@RequestParam(value = "mrn", defaultValue = "") String mrn) {

        if(mrn.equalsIgnoreCase("99999")){
            return new Patient("99999","Tom","Meaney",30,"29 Friars Walk","Ballyphehane","Cork City");
        }
        return new Patient("1234","","",0,"","","");

    }

    @RequestMapping("/patients")
    public List<Patient> patients() {

        List<Patient> pList = new ArrayList<>();
        pList.add(new Patient("99999","Tom","Meaney",30,"29 Friars Walk","Ballyphehane","Cork City"));
        pList.add(new Patient("88888","Alice","Muller",22,"29 Friars Walk","Ballyphehane","Cork City"));
        pList.add(new Patient("12345","Jack","Hanley",22,"Uam-Var","Bishopstown","Cork"));
        pList.add(new Patient("67890","James","Walsh",23,"Passage","PigTown","Cork"));
        pList.add(new Patient("54321","Martina","O' Driscoll",23,"Barrack street","Cork","Cork"));
        pList.add(new Patient("98765","Sean","Breen",25,"29 house road","Ballincollig","Cork"));

        return pList;
    }


}
