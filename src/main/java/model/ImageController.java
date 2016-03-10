package model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
    public String viewImage() throws IOException {
        return "data:image/webp;base64,"+encoded;
    }


}
