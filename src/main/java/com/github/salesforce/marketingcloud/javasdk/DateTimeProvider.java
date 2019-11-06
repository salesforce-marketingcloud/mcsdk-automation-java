package com.github.salesforce.marketingcloud.javasdk;

import java.time.LocalDateTime;

public class DateTimeProvider {
    LocalDateTime date;

    public DateTimeProvider()
    {
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getCurrentDate() {
        return this.date;
    }
}
