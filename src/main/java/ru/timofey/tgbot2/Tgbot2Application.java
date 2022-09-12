package ru.timofey.tgbot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class Tgbot2Application {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.stackabuse.com");
        try {
            HttpURLConnection connection =(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SpringApplication.run(Tgbot2Application.class, args);
    }
}
