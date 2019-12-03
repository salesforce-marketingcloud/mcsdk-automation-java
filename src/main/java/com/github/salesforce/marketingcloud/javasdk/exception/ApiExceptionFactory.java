package com.github.salesforce.marketingcloud.javasdk.exception;

import com.github.salesforce.marketingcloud.javasdk.ApiException;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class ApiExceptionFactory {
    public static ApiException create(Response response) {
        String responseBody = null;
        if (response.body() != null) {
            try {
                responseBody = response.body().string();
            } catch (IOException e) {
                return new ApiException(response.message(), e, response.code(), response.headers().toMultimap());
            }
        }
        switch (response.code())
        {
            case 400:
                return new BadRequestException(
                    responseBody, response.code(), response.headers().toMultimap(), responseBody);
            case 401:
                return new AuthenticationFailureException(
                    responseBody, response.code(), response.headers().toMultimap(), responseBody);
            case 403:
                return new UnauthorizedAccessException(
                    responseBody, response.code(), response.headers().toMultimap(), responseBody);
            case 404:
                return new ResourceNotFoundException(
                    responseBody, response.code(), response.headers().toMultimap(), responseBody);
            case 500:
                return new InternalServerErrorException(
                    responseBody, response.code(), response.headers().toMultimap(), responseBody);
            case 502:
                return new BadGatewayException(
                    responseBody, response.code(), response.headers().toMultimap(), responseBody);
            case 503:
                return new ServiceUnavailableException(
                    responseBody, response.code(), response.headers().toMultimap(), responseBody);
            case 504:
                return new GatewayTimeoutException(
                    responseBody, response.code(), response.headers().toMultimap(), responseBody);
            default:
                return new ApiException(responseBody, response.code(), response.headers().toMultimap(), responseBody);
        }
    }
}
