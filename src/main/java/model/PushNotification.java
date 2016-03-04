//package model;
//
///**
// * Created by tmeaney on 28/02/16.
// */
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//@Slf4j(topic = "IWACUSTLOG")
//public class PushNotification {
//
//    /** bshs api key */
//    public static final String API_KEY = "AIzaSyDaoNvDmn7uYa4u_XnBO9tOiuQaRyhKa9M";
//    private String URL = "https://android.googleapis.com/gcm/send";
//    private String topic = "/topics/global";
//
//    /**
//     * reference: https://developers.google.com/cloud-messaging/http-server-ref
//     *
//     * @param message The message to send the recipient
//     * @param token The token against the recipient
//     * @return
//     */
//    public boolean send(String message, String token){
//        return send(message, token, null);
//    }
//
//
//    /**
//     * reference: https://developers.google.com/cloud-messaging/http-server-ref
//     *
//     * @param message The message to send the recipient
//     * @param token The token against the recipient
//     * @param messageType The message type can identify the messaeg as being an 'alert' or some action such as 'logout'
//     * @return
//     */
//    public boolean send(String message, String token, String messageType){
//        log.info("Sending push notification: "+token);
//        boolean sendSuccessful = true;
//
//        JSONObject jGcmData = null;
//        JSONObject jData = null;
//
//        try {
//            // Prepare JSON containing the GCM message content. What to send and where to send.
//            jGcmData = new JSONObject();
//
//            // Where to send GCM message.
//            if (token!=null) {
//                jGcmData.put("to", token);
//            }
//            else {
//                jGcmData.put("to", topic);
//            }
//
//            // What to send in GCM message.
//            jData = new JSONObject();
//
//            jData.put("message", message);
//
//            if(messageType!=null) jData.put("messageType", messageType);
//
////            jGcmData.put("priority", "high");
//            jGcmData.put("data", jData);
//
//            sendSuccessful = sendGcmMessage(jGcmData);
//        }
//        catch (JSONException e) {
//            log.error("Error sending push notification", e);
//
//            sendSuccessful = false;
//        }
//        finally {
//            jData=null;
//            jGcmData=null;
//        }
//
//        return sendSuccessful;
//    }
//
//    public boolean sendGcmMessage(JSONObject jGcmData){
//        boolean sendSuccessful = true;
//
//        java.net.URL url = null;
//        HttpURLConnection conn = null;
//        OutputStream outputStream = null;
//        InputStream inputStream = null;
//
//        try {
//            // Create connection to send GCM Message request.
//            url = new URL(URL);
//            conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestProperty("Authorization", "key=" + API_KEY);
//            conn.setRequestProperty("Content-Type", "application/json");
//            conn.setRequestMethod("POST");
//            conn.setDoOutput(true);
//
//            // Send GCM message content.
//            outputStream = conn.getOutputStream();
//            outputStream.write(jGcmData.toString().getBytes());
//
//            // Read GCM response.
//            inputStream = conn.getInputStream();
//            String resp = IOUtils.toString(inputStream);
//
//            System.out.println(resp);
//            System.out.println("Check your device/emulator for notification or logcat for " +
//                    "confirmation of the receipt of the GCM message.");
//        }
//        catch (IOException e) {
//            log.error("Error sending gcm message", e);
//
//            sendSuccessful = false;
//        }
//        finally {
//            if(inputStream!=null){
//                try {inputStream.close();}
//                catch (IOException e) {}
//                inputStream=null;
//            }
//            if(outputStream!=null){
//                try {outputStream.close();}
//                catch (IOException e) {}
//                outputStream=null;
//            }
//            if(conn!=null){
//                conn.disconnect();
//                conn=null;
//            }
//            url=null;
//        }
//
//        return sendSuccessful;
//    }
//}