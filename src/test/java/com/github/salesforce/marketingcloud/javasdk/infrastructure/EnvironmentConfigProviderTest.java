package com.github.salesforce.marketingcloud.javasdk.infrastructure;

import com.github.salesforce.marketingcloud.javasdk.exception.EnvironmentVariableNotSetException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class EnvironmentConfigProviderTest {
    private final EnvironmentConfigProvider environmentConfigProvider = new EnvironmentConfigProvider();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldThrowEnvironmentVariableNotSetExceptionWhenTryingToGetAMandatoryEnvVariableThatIsNotSet() throws EnvironmentVariableNotSetException {
        exceptionRule.expect(EnvironmentVariableNotSetException.class);
        exceptionRule.expectMessage("Env variable NON_EXISTING_KEY is not set");

        environmentConfigProvider.get("NON_EXISTING_KEY", true);
    }

    @Test
    public void shouldReturnNullWhenTryingToGetAnOptionalEnvVariableThatIsNotSet() throws EnvironmentVariableNotSetException {
        String envVariableValue = environmentConfigProvider.get("NON_EXISTING_KEY", false);
        assertNull(envVariableValue);
    }

    @Test
    public void shouldReturnMandatoryEnvVariableValue() throws EnvironmentVariableNotSetException {
        String envVariableValue = environmentConfigProvider.get("SFMC_AUTH_BASE_URL", true);
        assertNotNull(envVariableValue);
    }
}
