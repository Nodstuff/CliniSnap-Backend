package xyz.nodstuff.controller;

import org.joda.time.DateTime;
import org.postgresql.util.PGTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.nodstuff.interfaces.ImageDAO;
import xyz.nodstuff.model.Image;

import java.util.List;

/**
 * Created by tmeaney on 10/03/16.
 */
@RestController
public class ImageController {

    @Autowired
    private ImageDAO imageDAO;

    @RequestMapping("/image")
    public void saveImage(@RequestBody Image uploadedImage){

        Image image = new Image();
        image.setMrn(uploadedImage.getMrn());
        image.setImage(uploadedImage.getImage());
        image.setThumbnail(uploadedImage.getThumbnail());
        image.setCreated_by("Tom Meaney");
        image.setModif_by("Tom Meaney");
        image.setCreate_dttm(new PGTimestamp(new DateTime().getMillis()));
        image.setModif_dttm(new PGTimestamp(new DateTime().getMillis()));

        imageDAO.save(image);
    }

    @RequestMapping("/getimages")
    public List<Image> getImages(@RequestParam String mrn){
        List<Image> images = imageDAO.findAllByMrn(mrn);

        for(Image i : images){
            i.setImage("");
        }
        return images;
    }


    @RequestMapping("/getimage")
    public Image getImage(@RequestParam int imageId){
        return imageDAO.findById(imageId);
    }
}

