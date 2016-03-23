package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by tmeaney on 10/03/16.
 */
@RestController
public class ImageController {

    @Autowired
    private DataSource datasource;

    private String encoded = "";
    private String mrn = "";

    @RequestMapping("/image")
    public void saveImage(@RequestParam MultiValueMap<String, String> paramMap){
        mrn = paramMap.getFirst("mrn");
        encoded = paramMap.getFirst("encodedImage");
        connect(encoded, mrn);
    }

    @RequestMapping("/view-image")
    public String viewImage() throws IOException {
        return "data:image/webp;base64,"+encoded;
    }

    public void connect(String encodedImage, String mrn){
        String sql = "INSERT INTO \"image\"" +
                "(mrn, encoded_image, create_dttm, created_by, modif_by, modif_dttm) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;

        try {
            conn = datasource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mrn);
            ps.setString(2,encodedImage);
            ps.setTimestamp(3, new Timestamp(Calendar.getInstance().getTimeInMillis()));
            ps.setString(4, "Tom Meaney");
            ps.setString(5, "Tom Meaney");
            ps.setTimestamp(6, new Timestamp(Calendar.getInstance().getTimeInMillis()));
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

}
