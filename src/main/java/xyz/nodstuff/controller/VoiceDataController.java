package xyz.nodstuff.controller;

import org.joda.time.DateTime;
import org.postgresql.util.PGTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.nodstuff.interfaces.VoiceDAO;
import xyz.nodstuff.model.VoiceRecording;

/**
 * Created by tmeaney on 10/03/16.
 */
@RestController
public class VoiceDataController {

    @Autowired
    private VoiceDAO voiceDAO;

    @RequestMapping("/voice")
    public void saveImage(@RequestBody VoiceRecording data){

        VoiceRecording voice = new VoiceRecording();
        voice.setMrn(data.getMrn());
        voice.setData(data.getData());
        voice.setCreate_by("Tom Meaney");
        voice.setModif_by("Tom Meaney");
        voice.setCreate_dttm(new PGTimestamp(new DateTime().getMillis()));
        voice.setModif_dttm(new PGTimestamp(new DateTime().getMillis()));

        voiceDAO.save(voice);
    }

//    @RequestMapping("/getimages")
//    public List<Image> getImages(@RequestParam String mrn){
//        List<Image> images = imageDAO.findAllByMrn(mrn);
//
//        for(Image i : images){
//            i.setImage("");
//        }
//        return images;
//    }
//
//
//    @RequestMapping("/getimage")
//    public Image getImage(@RequestParam int imageId){
//        return imageDAO.findById(imageId);
//    }
}

