package mb.mapping.traveller

import mb.mapping.traveller.Walker
import spock.lang.Specification
import spock.lang.Unroll

import static helper.TestFootpathBetweenBuilder.footpathBetween
import static helper.TestRoadBetweenBuilder.roadBetween

class WalkerSpec extends Specification {

    Walker walker

    def 'setup'() {
        walker = new Walker()
    }

    @Unroll
    def 'canTravelOn #route #canTravelOn'() {
        expect:
        walker.canTravelOn(route) == canTravelOn

        where:
        route                     | canTravelOn
        roadBetween('a', 'b')     | true
        footpathBetween('a', 'b') | true
    }
}
