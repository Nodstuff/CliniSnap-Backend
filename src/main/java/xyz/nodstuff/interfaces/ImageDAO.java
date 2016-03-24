package xyz.nodstuff.interfaces;

import org.springframework.data.repository.CrudRepository;
import xyz.nodstuff.model.Image;

import java.util.List;

/**
 * Created by tmeaney on 24/03/16.
 */
public interface ImageDAO extends CrudRepository<Image, Long> {

    /**
     * Return the Patient having the passed email or null if no user is found.
     *
     * @param mrn the patient mrn.
     */
    Image findByMrn(String mrn);

    List<Image> findAllByMrn(String mrn);

    Image findById(int id);

}
