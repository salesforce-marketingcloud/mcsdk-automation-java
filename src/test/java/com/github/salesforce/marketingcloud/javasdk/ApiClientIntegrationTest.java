package com.github.salesforce.marketingcloud.javasdk;

import com.github.salesforce.marketingcloud.javasdk.validation.ModelValidator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApiClientIntegrationTest {

    @Test
    public void userAgentShouldMatchTheExpectedFormat() {
        ApiClient apiClient = new ApiClient(new RuntimeInformationProvider(), new ModelValidator());

        String actualUserAgent = apiClient.getUserAgent();
        String[] userAgentParts = actualUserAgent.split("/");

        assertEquals(6, userAgentParts.length);

        String sdkName = userAgentParts[0];
        String languageName = userAgentParts[1];
        String sdkVersion = userAgentParts[2];
        String javaVersion = userAgentParts[3];
        String osName = userAgentParts[4];
        String osVersion = userAgentParts[5];

        assertEquals(ApiClient.SDK_NAME, sdkName);
        assertEquals(ApiClient.LANGUAGE_NAME, languageName);
        assertEquals(ApiClient.SDK_VERSION, sdkVersion);
        assertNotNull(javaVersion);
        assertNotNull(osName);
        assertNotNull(osVersion);
    }
}
