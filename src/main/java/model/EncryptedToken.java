package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by tmeaney on 16/03/16.
 */
@Data
@AllArgsConstructor
public class EncryptedToken {
    private String token;
}
