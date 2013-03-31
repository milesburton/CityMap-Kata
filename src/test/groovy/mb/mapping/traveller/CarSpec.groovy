package mb.mapping.traveller

import mb.mapping.traveller.Car
import spock.lang.Specification
import spock.lang.Unroll

import static helper.TestFootpathBetweenBuilder.footpathBetween
import static helper.TestRoadBetweenBuilder.roadBetween

class CarSpec extends Specification {

    Car traveller

    def 'setup'() {
        traveller = new Car()
    }

    @Unroll
    def 'canTravelOn #route #canTravelOn'() {
        expect:
        traveller.canTravelOn(route) == canTravelOn

        where:
        route                     | canTravelOn
        roadBetween('a', 'b')     | true
        footpathBetween('a', 'b') | false
    }
}
