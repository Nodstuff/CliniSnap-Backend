package xyz.nodstuff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by tmeaney on 24/03/16.
 */
@Entity
@Table(name = "image")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrn;
    private String image;
    private Timestamp create_dttm;
    private String created_by;
    private String modif_by;
    private Timestamp modif_dttm;

}
