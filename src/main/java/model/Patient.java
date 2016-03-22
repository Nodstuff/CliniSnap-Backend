package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by tmeaney on 11/02/16.
 */
@Entity
@Table(name = "patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrn;
    private String fname;
    private String sname;
    private Date date_of_birth;
    private String address1;
    private String address2;
    private String address3;
    private String phone;
    private String created_by;
    private Date create_dttm;
    private String modif_by;
    private Date modif_dttm;

}
