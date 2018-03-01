package com.singham.yuan.spring.boot.web.service.client.http;

import org.springframework.stereotype.Component;
import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;

import java.io.IOException;
import java.net.HttpURLConnection;

@Component
public class EnhanceHttpUrlConnectionMessageSender extends HttpUrlConnectionMessageSender {

    private static final int readTimeout = 10000;

    private static final int connectionTimeout = 10000;

    @Override
    protected void prepareConnection(HttpURLConnection connection) throws IOException {
        connection.setReadTimeout(readTimeout);
        connection.setConnectTimeout(connectionTimeout);
        super.prepareConnection(connection);
    }

}
