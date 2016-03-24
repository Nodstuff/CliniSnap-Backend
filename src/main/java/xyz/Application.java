package xyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by tmeaney on 11/02/16.
 */
@SpringBootApplication
@EnableWebMvc
@ComponentScan({"xyz.nodstuff"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

