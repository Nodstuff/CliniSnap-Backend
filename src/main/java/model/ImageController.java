package model;

import org.springframework.util.MultiValueMap;
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
    private String mrn = "";

    @RequestMapping("/image")
    public void saveImage(@RequestParam MultiValueMap<String, String> paramMap){
        mrn = paramMap.getFirst("mrn");
        encoded = paramMap.getFirst("encodedImage");
    }

    @RequestMapping("/view-image")
    public String viewImage() throws IOException {
        return mrn+ "     data:image/webp;base64,"+encoded;
    }


}
