package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by tmeaney on 11/02/16.
 */
@Data
@AllArgsConstructor
public class Patient {

    private String mrn;
    private String fname;
    private String sname;
    private Integer age;
    private String address1;
    private String address2;
    private String address3;


}
