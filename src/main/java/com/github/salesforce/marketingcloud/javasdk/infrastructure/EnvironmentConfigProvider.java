package com.github.salesforce.marketingcloud.javasdk.infrastructure;

import com.github.salesforce.marketingcloud.javasdk.exception.EnvironmentVariableNotSetException;

public class EnvironmentConfigProvider {
    public String get(String variable, boolean mandatory) throws EnvironmentVariableNotSetException {

        String envVariableValue = System.getenv(variable);

        if(envVariableValue != null) {
            return envVariableValue;
        }

        if(mandatory) {
            throw new EnvironmentVariableNotSetException(variable);
        }

        return null;
    }

    public String get(String variable) throws EnvironmentVariableNotSetException {
        return get(variable, true);
    }
}
