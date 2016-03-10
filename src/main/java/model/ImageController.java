package model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
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
    public void viewImage(HttpServletResponse response){
        try {
            response.sendRedirect("data:image/webp;base64,"+encoded);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
