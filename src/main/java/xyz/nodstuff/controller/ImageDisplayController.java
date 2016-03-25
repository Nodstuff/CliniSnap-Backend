package xyz.nodstuff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.nodstuff.interfaces.ImageDAO;

/**
 * Created by tmeaney on 24/03/16.
 */
@Controller
public class ImageDisplayController {

    @Autowired
    private ImageDAO imageDAO;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="imageId") int id, Model model) {

        String image = "data:image/jpeg;base64," + imageDAO.findById(id).getImage();

        model.addAttribute("image", image);

        return "image-display";
    }

}
