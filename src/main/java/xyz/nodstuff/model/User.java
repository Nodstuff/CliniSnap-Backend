package xyz.nodstuff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by tmeaney on 24/02/16.
 */
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String useremail;
    private String userpword;
    private String authtoken;
    private String pushtoken;
    private String created_by;
    private Timestamp create_dttm;
    private String modif_by;
    private Timestamp modif_dttm;
}
