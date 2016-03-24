package xyz.nodstuff.controller;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import xyz.nodstuff.interfaces.ImageDAO;
import xyz.nodstuff.model.Image;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by tmeaney on 10/03/16.
 */
@RestController
public class ImageController {

    @Autowired
    private ImageDAO imageDAO;

    private String encoded = "";
    private String mrn = "";

    @RequestMapping("/image")
    public void saveImage(@RequestParam MultiValueMap<String, String> paramMap){

        Image image = new Image();
        image.setImage(paramMap.getFirst("encodedImage"));
        image.setMrn(paramMap.getFirst("mrn"));
        image.setCreated_by("Tom Meaney");
        image.setModif_by("Tom Meaney");
        image.setCreate_dttm(new Timestamp(new DateTime().getMillis()));
        image.setModif_dttm(new Timestamp(new DateTime().getMillis()));

        imageDAO.save(image);
    }

    @RequestMapping("/getimages")
    public List<Image> getImages(@RequestParam String mrn){
        return imageDAO.findAllByMrn(mrn);
    }

    @RequestMapping("/view-image")
    public String viewImage(ModelAndView modelAndView) throws IOException {
        //return "data:image/webp;base64,"+encoded;
        return "index";
    }
}
