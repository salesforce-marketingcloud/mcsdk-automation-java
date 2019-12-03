package com.github.salesforce.marketingcloud.javasdk;

import java.util.Arrays;
import java.util.List;

public class RuntimeInformationProvider {
    final List<String> systemPropertyKeys;

    public RuntimeInformationProvider()
    {
        systemPropertyKeys = Arrays.asList(
            "java.version",
            "os.name",
            "os.version"
        );
    }

    String getForUserAgentString() {
        StringBuilder stringBuilder = new StringBuilder();
        try
        {
            for (int i = 0; i < systemPropertyKeys.size(); i++) {
                stringBuilder.append(System.getProperty(systemPropertyKeys.get(i), "NA"));

                if(i < systemPropertyKeys.size() - 1)
                {
                    stringBuilder.append("/");
                }
            }
        }
        catch (SecurityException ex)
        {
            stringBuilder.append("NA");
        }

        return stringBuilder.toString();
    }
}
