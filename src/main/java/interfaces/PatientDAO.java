package interfaces;

import model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tmeaney on 22/03/16.
 */
@Transactional
public interface PatientDAO extends CrudRepository<Patient, Long> {

    /**
     * Return the user having the passed email or null if no user is found.
     *
     * @param mrn the user mrn.
     */
    Patient findByMrn(String mrn);
    Patient findById(int id);


} // class UserDao