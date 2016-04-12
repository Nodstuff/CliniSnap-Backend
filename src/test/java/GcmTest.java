import org.junit.Test;
import xyz.nodstuff.gcm.GcmSender;

/**
 * Created by tmeaney on 25/03/16.
 */
public class GcmTest {

    @Test
    public void testGcmSend(){
        GcmSender sender = new GcmSender();
        sender.sendMessage("Test message","dY5zQg6aqVA:APA91bFyyanAEI8MJhaEg4DevfPhNDIuY2-v7uPom5Cz_9CNdtGMHE-a6hSViNILgaZydhtBxKhmJRjbOR2m0bXha8Zn-EwVIQkHliXgHizuL2AUQijNSvjNTcUDghY_hVdS_OXFd-Ok");
    }
}
