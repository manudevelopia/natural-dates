# Natural Dates
Parse dates in natural language and checks if proposed date is now. Comparison truncate to minute by default.

## How often?
- daily

```java
    NaturalDates naturalDates = new NaturalDates("daily at 9:15")
    naturalDates.isNow()
```

## How often? (TBD)
- monday, tuesday, wednesday, thursday, friday, saturday, sunday (this is weekly) at 00:00
- monthly 4th at 00:00
- January, February, March, April, May, June, July, August, September, October, November, December 4th at 00:00