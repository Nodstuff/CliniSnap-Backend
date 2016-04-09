import org.junit.Test;
import xyz.nodstuff.gcm.GcmSender;

/**
 * Created by tmeaney on 25/03/16.
 */
public class GcmTest {

    @Test
    public void testGcmSend(){
        GcmSender sender = new GcmSender();
        sender.sendMessage("Test message","d-NTO0tYQ3E:APA91bGf7v7sCdWvnr5CdWy5doODJL6oMbes4Gr9dJ8m0g0LFHYMVK7KtQMUmlr4fQesCJAppY2GiBPrTDa66RFEqJfE7nnQvn3ao42pX5n5ZYr4jITm5UlygRBqXe1LkuwD-iPajSQz");
    }
}
