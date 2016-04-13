package xyz.nodstuff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by tmeaney on 13/04/16.
 */
@Entity
@Table(name = "voice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoiceRecording {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrn;
    private String data;
    private String create_by;
    private String modif_by;
    private Timestamp create_dttm;
    private Timestamp modif_dttm;


}
