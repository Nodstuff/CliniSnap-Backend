package model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by tmeaney on 11/02/16.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

//        Date parsedDate = null;
//
//        String dateInString = "20/07/1985";
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        try {
//            parsedDate = formatter.parse(dateInString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(formatter.format(parsedDate));
    }
}