import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by tmeaney on 11/02/16.
 */
@SpringBootApplication
@ComponentScan({"xyz.nodstuff.config","xyz.nodstuff.model","xyz.nodstuff.interfaces","xyz.nodstuff.gcm","xyz.nodstuff.crypto","xyz.nodstuff.controller"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

