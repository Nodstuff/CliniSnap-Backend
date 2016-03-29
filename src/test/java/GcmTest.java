import org.junit.Test;
import xyz.nodstuff.gcm.GcmSender;

/**
 * Created by tmeaney on 25/03/16.
 */
public class GcmTest {

    @Test
    public void testGcmSend(){
        GcmSender sender = new GcmSender();
        sender.sendMessage("Test message","c82gbCvupk0:APA91bEXkXPKeatzwXNQHDYlOmzW-KwB3XqaQfTmkeclYb5Quvh9uqQarvI6whz1xQMewHVU5AJZ_X7PZYPMx6iXzKpscllrkX0huQS1RrYb1KlMlxyGrJHveCXRbmNT8nq3OMAwhxpY");
    }

}
