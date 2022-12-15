package com.app.ohmybooks.component.responseEntity;

import org.springframework.http.HttpHeaders;

public final class HeaderHelper {

    private final static String ADDITIONAL_MESSAGE = "messageSuccess";
    private final static String FILE_NAME = "fileName";

    public static HttpHeaders getHeadersMessage(String message) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(ADDITIONAL_MESSAGE, message);
        return responseHeaders;
    }

    public static HttpHeaders getHeadersFile(String fileName) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(FILE_NAME, fileName);
        return responseHeaders;
    }

}