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

        SpringApplication.run(Tgbot2Application.class, args);
    }
}
