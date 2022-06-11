package info.developia

import spock.lang.Specification

import java.time.LocalDateTime

class NaturalDatesTest extends Specification {
    def "should be parsed to return is now false"() {
        given:
        LocalDateTime now = LocalDateTime.now().withHour(21).withMinute(15)
        String dateDescription = 'daily at 9:15'
        when:
        def naturalDates = new NaturalDates(dateDescription)
        then:
        naturalDates.isNot(now)
    }

    def "should be parsed to return is now true"() {
        given:
        LocalDateTime now = LocalDateTime.now().withHour(9).withMinute(15)
        String dateDescription = 'daily at 9:15'
        when:
        def naturalDates = new NaturalDates(dateDescription)
        then:
        naturalDates.is(now)
    }

    def "should be parsed to return is now tomorrow too"() {
        given:
        LocalDateTime now = LocalDateTime.now().plusDays(1).withHour(9).withMinute(15)
        String dateDescription = 'daily at 9:15'
        when:
        def naturalDates = new NaturalDates(dateDescription)
        then:
        naturalDates.is(now)
    }
}
