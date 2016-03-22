package model;

import crypto.AESCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.security.GeneralSecurityException;
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
    private String testKey = "helloworld";

    @RequestMapping("/login")
    public EncryptedToken login() {
        UUID idOne = UUID.randomUUID();
        connect(idOne);
        try {
            return new EncryptedToken(AESCrypt.encrypt(testKey,"testing"));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return new EncryptedToken(null);
    }

    public void connect(UUID uuid){
        String sql = "UPDATE \"user\" " +
                "SET auth_token = (?) WHERE username = 'Tom'";
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
