package com.github.salesforce.marketingcloud.javasdk.exception;

import com.github.salesforce.marketingcloud.javasdk.ApiException;

import java.util.List;
import java.util.Map;

public class UnauthorizedAccessException extends ApiException {
    public UnauthorizedAccessException(String message, int code, Map<String, List<String>> responseHeaders, String responseBody) {
        super(message, code, responseHeaders, responseBody);
    }
}
