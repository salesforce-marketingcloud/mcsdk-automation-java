package com.github.salesforce.marketingcloud.javasdk.exception;

public class EnvironmentVariableNotSetException extends Exception {
    public EnvironmentVariableNotSetException(String variable) {
        super("Env variable " + variable + " is not set");
    }
}
