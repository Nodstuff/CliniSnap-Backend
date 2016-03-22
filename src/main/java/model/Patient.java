package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tmeaney on 11/02/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    private String mrn;
    private String fname;
    private String sname;
    private String dob;
    private String address1;
    private String address2;
    private String address3;
    private String phone;
}
