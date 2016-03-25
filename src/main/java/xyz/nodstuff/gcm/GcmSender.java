package xyz.nodstuff.gcm;

/**
 * Created by tmeaney on 07/03/16.
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@Slf4j(topic = "DB")
public class GcmSender {

    public static final String API_KEY = "AIzaSyATiCWVsn3Fs7qtA3J3b2yjERlJvfFMx4g";

    public void sendMessage(String message, String token){
        try {
            // Prepare JSON containing the GCM message content. What to send and where to send.
            JSONObject jGcmData = new JSONObject();
            JSONObject jData = new JSONObject();
            JSONObject jNotification = new JSONObject();

            jNotification.put("body","Great match!");
            jNotification.put("title","Portugal Vs. Denmark");
            jNotification.put("icon","largebonslogo");


            jData.put("message", message);
            // Where to send GCM message.
            jGcmData.put("to", token.trim());

            // What to send in GCM message.
            jGcmData.put("data", jData);

            // Put notification in GCM Message
            jGcmData.put("notification",jNotification);

            // Create connection to send GCM Message request.
            URL url = new URL("https://android.googleapis.com/gcm/send");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Authorization", "key=" + API_KEY);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // Send GCM message content.
            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(jGcmData.toString().getBytes());

            // Read GCM response.
            InputStream inputStream = conn.getInputStream();
            String resp = IOUtils.toString(inputStream);
            System.err.println("*************"+resp);

        } catch (IOException e) {

            log.error("Error in GcmSender: ",e);

        }
    }

}