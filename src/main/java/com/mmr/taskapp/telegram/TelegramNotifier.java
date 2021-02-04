package com.mmr.taskapp.telegram;

import org.springframework.stereotype.Service;

import javax.ws.rs.core.UriBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

@Service
public class TelegramNotifier {

    private static final String CHAT_ID_VALUE = "572339173";
    private static final String TOKEN = "1571259214:AAHr0OPZNJqPMiYa9-iTMhWy6zGI4QwSNlI";
    private static final String HTTPS_API_TELEGRAM_ORG = "https://api.telegram.org";
    private static final String PATH = "/{token}/sendMessage";
    private static final String CHAT_ID = "chat_id";
    private static final String TEXT = "text";
    private static final String BOT = "bot";
    private static final String GET = "GET";
    private static final String MESSAGE_IS_NOT_DELIEVERED_DUE_TO = "Message is not delievered due to ";
    private static final String CAN_NOT_ESTABLISH_HTTP_CONNECTION = "Can not establish http connection";
    private static final String URL_CAN_NOT_BE_CONSTRUCTED = "URL can not be constructed";
    private static final boolean ENABLED = false;

    public String sendMessage(String message) {
        if (ENABLED) {
            URL url = getUrl(message);

            HttpURLConnection connection = getHttpURLConnection(url);

            return getResponse(connection);
        }

        return null;
    }

    private String getResponse(HttpURLConnection connection) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            return content.toString();
        } catch (IOException e) {
            throw new RuntimeException(MESSAGE_IS_NOT_DELIEVERED_DUE_TO + e.getCause());
        }
    }

    private HttpURLConnection getHttpURLConnection(URL url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(GET);
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            return connection;
        } catch (IOException e) {
            throw new RuntimeException(CAN_NOT_ESTABLISH_HTTP_CONNECTION + e.getCause());
        }
    }

    private URL getUrl(String message) {
        try {
            URI uri = UriBuilder
                    .fromUri(HTTPS_API_TELEGRAM_ORG)
                    .path(PATH)
                    .queryParam(CHAT_ID, CHAT_ID_VALUE)
                    .queryParam(TEXT, message)
                    .build(BOT + TOKEN);

            return uri.toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(URL_CAN_NOT_BE_CONSTRUCTED + e.getCause());
        }
    }
}
