package com.github.salesforce.marketingcloud.javasdk;

import java.time.LocalDateTime;

public class SettableDateTimeProvider extends DateTimeProvider {
    LocalDateTime localDateTime;

    public SettableDateTimeProvider(LocalDateTime localDateTime)
    {
        this.localDateTime = localDateTime;
    }

    @Override
    public LocalDateTime getCurrentDate() {
        return localDateTime;
    }

    public void setCurrentDate(LocalDateTime localDateTime)
    {
        this.localDateTime = localDateTime;
    }
}
