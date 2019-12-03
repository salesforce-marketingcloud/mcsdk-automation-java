package com.github.salesforce.marketingcloud.javasdk;

import com.github.salesforce.marketingcloud.javasdk.exception.*;
import com.squareup.okhttp.*;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApiExceptionFactoryTest {
    private final String headerKey = "header-key";
    private final String headerValue = "header-value";
    private final String responseBody = "{'data': 'response body'}";
    private final String message = "message";

    @Test
    public void shouldCreateBadRequestException() {
        int code = 400;
        Response response = createResponse(code);

        ApiException exception = ApiExceptionFactory.create(response);

        assertExceptionProperties(code, BadRequestException.class, exception);
    }

    @Test
    public void shouldCreateAuthenticationFailureException() {
        int code = 401;
        Response response = createResponse(code);

        ApiException exception = ApiExceptionFactory.create(response);

        assertExceptionProperties(code, AuthenticationFailureException.class, exception);
    }

    @Test
    public void shouldCreateUnauthorizedAccessException() {
        int code = 403;
        Response response = createResponse(code);

        ApiException exception = ApiExceptionFactory.create(response);

        assertExceptionProperties(code, UnauthorizedAccessException.class, exception);
    }

    @Test
    public void shouldCreateResourceNotFoundException() {
        int code = 404;
        Response response = createResponse(code);

        ApiException exception = ApiExceptionFactory.create(response);

        assertExceptionProperties(code, ResourceNotFoundException.class, exception);
    }

    @Test
    public void shouldCreateInternalServerErrorException() {
        int code = 500;
        Response response = createResponse(code);

        ApiException exception = ApiExceptionFactory.create(response);

        assertExceptionProperties(code, InternalServerErrorException.class, exception);
    }

    @Test
    public void shouldCreateBadGatewayException() {
        int code = 502;
        Response response = createResponse(code);

        ApiException exception = ApiExceptionFactory.create(response);

        assertExceptionProperties(code, BadGatewayException.class, exception);
    }

    @Test
    public void shouldCreateServiceUnavailableException() {
        int code = 503;
        Response response = createResponse(code);

        ApiException exception = ApiExceptionFactory.create(response);

        assertExceptionProperties(code, ServiceUnavailableException.class, exception);
    }

    @Test
    public void shouldCreateGatewayTimeoutException() {
        int code = 504;
        Response response = createResponse(code);

        ApiException exception = ApiExceptionFactory.create(response);

        assertExceptionProperties(code, GatewayTimeoutException.class, exception);
    }

    @Test
    public void shouldCreateApiExceptionWhenStatusCodeIsNotCoveredBySpecificException() {
        int code = 0;
        Response response = createResponse(code);

        ApiException exception = ApiExceptionFactory.create(response);

        assertExceptionProperties(code, ApiException.class, exception);
    }

    @Test
    public void shouldCreateApiExceptionWhenBodyThrows() throws IOException {
        int code = 0;
        Response response = createResponse(code);
        // make the next call to response.body().string() throw exception, by invoking .string() once
        response.body().string();

        ApiException exception = ApiExceptionFactory.create(response);

        assertEquals(ApiException.class, exception.getClass());
        assertEquals(message, exception.getMessage());
        assertEquals(IOException.class, exception.getCause().getClass());
    }

    private void assertExceptionProperties(int code, Class<?> exceptionClass, ApiException exception) {
        assertEquals(code, exception.getCode());
        assertEquals(exceptionClass, exception.getClass());
        assertEquals(responseBody, exception.getMessage());
        assertEquals(responseBody, exception.getResponseBody());

        Map<String, List<String>> responseHeaders = exception.getResponseHeaders();
        assertEquals(1, responseHeaders.size());
        assertTrue(responseHeaders.containsKey(headerKey));
        assertEquals(headerValue, responseHeaders.get(headerKey).get(0));
    }

    private Response createResponse(int code) {
        Response.Builder builder = new Response.Builder();
        return builder
                .request(new Request.Builder().url("https://rest.com").build())
                .protocol(Protocol.HTTP_1_1)
                .code(code)
                .body(ResponseBody.create(
                        MediaType.parse("application/json"),
                        responseBody))
                .message(message)
                .header(headerKey, headerValue)
                .build();
    }
}
