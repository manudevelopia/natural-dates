package info.developia

import spock.lang.Specification

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class NaturalDatesTest extends Specification {
    def "should be parsed to return is now"() {
        given:
        LocalDateTime now = LocalDateTime.now().withHour(9).withMinute(15).truncatedTo(ChronoUnit.MINUTES)
        String dateDescription = 'daily at 9:15'
        when:
        def naturalDates = new NaturalDates(dateDescription)
        then:
        naturalDates.is(now)
    }

    def "should be parsed to return is now tomorrow too"() {
        given:
        LocalDateTime now = LocalDateTime.now().plusDays(1).withHour(9).withMinute(15).truncatedTo(ChronoUnit.MINUTES)
        String dateDescription = 'daily at 9:15'
        when:
        def naturalDates = new NaturalDates(dateDescription)
        then:
        naturalDates.is(now)
    }
}
