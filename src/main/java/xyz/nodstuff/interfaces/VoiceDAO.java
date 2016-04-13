package xyz.nodstuff.interfaces;

import org.springframework.data.repository.CrudRepository;
import xyz.nodstuff.model.VoiceRecording;

import java.util.List;

/**
 * Created by tmeaney on 24/03/16.
 */
public interface VoiceDAO extends CrudRepository<VoiceRecording, Long> {

    /**
     * Return the Patient having the passed email or null if no user is found.
     *
     * @param mrn the patient mrn.
     */
    VoiceRecording findByMrn(String mrn);

    List<VoiceRecording> findAllByMrn(String mrn);

    VoiceRecording findById(int id);

}
