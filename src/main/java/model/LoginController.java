package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by tmeaney on 11/02/16.
 */
@RestController
public class LoginController {

    @Autowired
    private DataSource datasource;

    @RequestMapping("/login")
    public UUID login() {
        UUID idOne = UUID.randomUUID();
        connect(idOne);
        return idOne;
    }

    public void connect(UUID uuid){
        String sql = "INSERT INTO \"user\" " +
                "(auth_token) VALUES (?) WHERE username = 'Tom'";
        Connection conn = null;

        try {
            conn = datasource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, uuid.toString());
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
