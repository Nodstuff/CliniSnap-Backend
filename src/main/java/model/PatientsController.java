package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by tmeaney on 11/02/16.
 */
@RestController
public class PatientsController {

    @Autowired
    private DataSource datasource;

    @RequestMapping("/patient")
    public Patient patient(@RequestParam(value = "mrn", defaultValue = "") String mrn) {

//        List<Patient> pList = new ArrayList<>();
//        pList.add(new Patient("99999","Tom","Meaney","20/07/1985","29 Friars Walk","Ballyphehane","Cork City","0858210277"));
//        pList.add(new Patient("88888","Alice","Muller","25/03/1994","29 Friars Walk","Ballyphehane","Cork City","0831412345"));
//        pList.add(new Patient("12345","Jack","Hanley","10/10/1993","Uam-Var","Bishopstown","Cork","0214543456"));
//        pList.add(new Patient("67890","James","Walsh","12/06/1991","Passage","PigTown","Cork","0891645342"));
//        pList.add(new Patient("54321","Martina","O' Driscoll","09/02/1992","Barrack street","Cork","Cork","0867546352"));
//        pList.add(new Patient("98765","Sean","Breen","19/12/1990","29 house road","Ballincollig","Cork","0648574635"));
//        pList.add(new Patient("240910","Oscar","Quill Walsh","07/11/1973","29 house road","Castle View","Cork","0648574635"));
//
//
//        for(Patient p: pList){
//
//            if (p.getMrn().equals(mrn)) {
//                return p;
//            }
//        }


        return retrieve(mrn);
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

    public void insert(Patient patient){

        Date parsedDate = null;

        String dateInString = patient.getDob();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            parsedDate = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO \"patient\"" +
                "(mrn, fname, sname, date_of_birth, address1, address2, address3," +
                " phone, created_by, create_dttm, modif_by,modif_dttm) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";

        Connection conn = null;

        try {
            conn = datasource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, patient.getMrn());
            ps.setString(2,patient.getFname());
            ps.setString(3,patient.getSname());
            ps.setTimestamp(4,new Timestamp(parsedDate.getTime()));
            ps.setString(5,patient.getAddress1());
            ps.setString(6,patient.getAddress2());
            ps.setString(7,patient.getAddress3());
            ps.setString(8,patient.getPhone());
            ps.setString(9, "Tom Meaney");
            ps.setTimestamp(10, new Timestamp(Calendar.getInstance().getTimeInMillis()));
            ps.setString(11, "Tom Meaney");
            ps.setTimestamp(12, new Timestamp(Calendar.getInstance().getTimeInMillis()));
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public Patient retrieve(String mrn){

        Patient p = new Patient();

        String sql = "SELECT * FROM \"patient\"" +
                "WHERE mrn = ?";

        Connection conn = null;

        try {
            conn = datasource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mrn);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                p.setMrn(rs.getString("mrn"));
                p.setFname(rs.getString("fname"));
                p.setSname(rs.getString("sname"));
                p.setDob(rs.getString("date_of_birth"));
            }

            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }

        return p;
    }

}
