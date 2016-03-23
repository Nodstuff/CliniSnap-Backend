package xyz.nodstuff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tmeaney on 04/03/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alert {

    private String id;
    private String sender;
    private String recipient;
    private String message;
}
