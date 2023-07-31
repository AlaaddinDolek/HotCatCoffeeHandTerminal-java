package com.HandTerminal.HotCatCafe.exceptions;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    private final ObjectMapper objectMapper;

    public RestTemplateResponseErrorHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError());
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        try {
            if (response.getBody() != null) {
                String responseBody = new String(response.getBody().readAllBytes(), StandardCharsets.UTF_8);
                ErrorResponse errorResponse = objectMapper.readValue(responseBody, ErrorResponse.class);
                throw new ServiceException(errorResponse);
            } else {
                throw new ServiceException(new ErrorResponse(new Date(), "Something went wrong", "No response body"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (response.getBody() != null) {
                response.getBody().close();
            }
        }
    }
}