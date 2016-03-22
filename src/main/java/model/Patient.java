package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private String dob;
    private String address1;
    private String address2;
    private String address3;
    private String phone;

}
