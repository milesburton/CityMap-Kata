package mb

import spock.lang.Specification
import spock.lang.Unroll

class CityMapInteractorIntegrationSpec extends Specification {

    @Unroll
    def 'isJourneyPossible from #startLocation to #endLocation when walking'() {

        given:
        CityMapInteractor cityMapInteractor = new CityMapInteractor('a-b,b-a')

        when:
        def isJourneyPossibleOnFoot = cityMapInteractor.isJourneyPossible(startLocation, endLocation, true)

        then:
        isJourneyPossibleOnFoot

        where:
        startLocation | endLocation
        'a'           | 'a'
        'a'           | 'b'
        'b'           | 'a'
    }

    @Unroll
    def 'isJourneyPossible from #startLocation to #endLocation when driving'() {

        given:
        CityMapInteractor cityMapInteractor = new CityMapInteractor('a=b,b=c,c=a')

        when:
        def isJourneyPossibleByCar = cityMapInteractor.isJourneyPossible(startLocation, endLocation, false)

        then:
        isJourneyPossibleByCar

        where:
        startLocation | endLocation
        'a'           | 'a'
        'a'           | 'c'
        'c'           | 'a'
        'c'           | 'b'
    }
}
