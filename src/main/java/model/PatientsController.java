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

        List<Patient> pList = new ArrayList<>();
        pList.add(new Patient("99999","Tom","Meaney","20/07/1985","29 Friars Walk","Ballyphehane","Cork City","0858210277"));
        pList.add(new Patient("88888","Alice","Muller","25/03/1994","29 Friars Walk","Ballyphehane","Cork City","0831412345"));
        pList.add(new Patient("12345","Jack","Hanley","10/10/1993","Uam-Var","Bishopstown","Cork","0214543456"));
        pList.add(new Patient("67890","James","Walsh","12/06/1991","Passage","PigTown","Cork","0891645342"));
        pList.add(new Patient("54321","Martina","O' Driscoll","09/02/1992","Barrack street","Cork","Cork","0867546352"));
        pList.add(new Patient("98765","Sean","Breen","19/12/1990","29 house road","Ballincollig","Cork","0648574635"));
        pList.add(new Patient("240910","Oscar","Quill Walsh","07/11/1973","29 house road","Castle View","Cork","0648574635"));

        for(Patient p: pList){
            if (p.getMrn().equals(mrn)) {
                return p;
            }
        }
        return new Patient("00000","Test","McTest","01/01/2000","TestRoad","TestTown","Cork","010987654");
    }

    @RequestMapping("/patients")
    public List<Patient> patients() {

        List<Patient> pList = new ArrayList<>();
        pList.add(new Patient("99999","Tom","Meaney","20/07/1985","29 Friars Walk","Ballyphehane","Cork City","0858210277"));
        pList.add(new Patient("88888","Alice","Muller","25/03/1994","29 Friars Walk","Ballyphehane","Cork City","0831412345"));
        pList.add(new Patient("12345","Jack","Hanley","10/10/1993","Uam-Var","Bishopstown","Cork","0214543456"));
        pList.add(new Patient("67890","James","Walsh","12/06/1991","Passage","PigTown","Cork","0891645342"));
        pList.add(new Patient("54321","Martina","O' Driscoll","09/02/1992","Barrack street","Cork","Cork","0867546352"));
        pList.add(new Patient("98765","Sean","Breen","19/12/1990","29 house road","Ballincollig","Cork","0648574635"));
        pList.add(new Patient("240910","Oscar","Quill Walsh","07/11/1973","29 house road","Castle View","Cork","0648574635"));

        return pList;
    }


}
