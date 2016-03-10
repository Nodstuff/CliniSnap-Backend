package model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tmeaney on 10/03/16.
 */
@RestController
public class ImageController {

    private String encoded = "";

    @RequestMapping("/image")
    public void saveImage(@RequestParam(value = "encodedImage", defaultValue = "") String encodedImage){
        encoded = encodedImage;
    }

    @RequestMapping("/view-image")
    public String viewImage(){
        return "redirect:data:image/webp;base64,"+encoded;
    }


}
