package mb

import mb.argumentprocessing.ArgumentsMerge
import mb.usecase.ArgumentsValidatorInteractor

import spock.lang.Specification

class CityMapSpec extends Specification {

    CityMap cityMap

    def 'construct'(){

        given:
        def routeAndLocations = 'a-b'
        Location startLocation = new Location(name:'a')
        Location endLocation = new Location(name:'b')
        BiDirectionalPath route = new BiDirectionalPath(startLocation: startLocation, endLocation:endLocation)

        when:
        cityMap = new CityMap(routeAndLocations)

        then:
        cityMap.graph == [startLocation, endLocation]
    }

}
