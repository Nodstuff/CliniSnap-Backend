package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by tmeaney on 24/02/16.
 */
@Data
@AllArgsConstructor
public class User {
    private String username;
    private String password;
}
