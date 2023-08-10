package org.itstep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Throwable {
        /*BotConfig botConfig = new BotConfig();
        System.out.println(botConfig.getName());
        */
        SpringApplication.run(Application.class, args);
    }

}
