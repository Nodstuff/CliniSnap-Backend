package model;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tmeaney on 11/02/16.
 */
@RestController
public class PatientsController {

    @Autowired
    private BasicDataSource datasource;

    @RequestMapping("/patient")
    public Patient patient(@RequestParam(value = "mrn", defaultValue = "") String mrn) {
        //return retrieve(mrn);
        return new ProjectDAO().getWithMrn(mrn);
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
                p.setAddress1(rs.getString("address1"));
                p.setAddress2(rs.getString("address2"));
                p.setAddress3(rs.getString("address3"));
                p.setPhone(rs.getString("phone"));
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
