package xyz.nodstuff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by tmeaney on 24/02/16.
 */
@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String useremail;
    private String userpword;
    private String auth_token;
    private String push_token;
    private String created_by;
    private Date create_dttm;
    private String modif_by;
    private Date modif_dttm;
}
