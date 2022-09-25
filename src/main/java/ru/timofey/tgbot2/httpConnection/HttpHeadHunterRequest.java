package ru.timofey.tgbot2.httpConnection;

import ru.timofey.tgbot2.vacancyEntities.HeadHunterForm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHeadHunterRequest {

    private URL url;
    //gotta be a bean
    private HttpURLConnection connection;
    private StringBuilder jsonString;

    public StringBuilder getJsonString() {
        return jsonString;
    }

    public HttpHeadHunterRequest(String urlString) {

        try {
            this.url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "HH-User-Agent");

            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String c;
            jsonString = new StringBuilder();
            while ((c = reader.readLine()) != null) {
                jsonString.append(c);
            }

            is.close();
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
