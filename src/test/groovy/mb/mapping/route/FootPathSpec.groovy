package mb.mapping.route

import mb.mapping.Location
import spock.lang.Specification
import spock.lang.Unroll

import static helper.TestFootpathBetweenBuilder.footpathBetween

class FootPathSpec extends Specification {

    @Unroll
    def 'canStartFrom #canStartFrom #origin when #route '() {

        expect:
        route.canStartFrom(origin) == canStartFrom

        where:
        route                     | origin                  | canStartFrom
        footpathBetween('a', 'b') | new Location(name: 'a') | true
        footpathBetween('a', 'b') | new Location(name: 'b') | true
        footpathBetween('a', 'b') | new Location(name: 'e') | false
    }

    @Unroll
    def 'canReach #canStartFrom #destination when #route '() {

        expect:
        route.canReach(destination) == isReachable

        where:
        route                     | destination             | isReachable
        footpathBetween('a', 'b') | new Location(name: 'b') | true
        footpathBetween('a', 'b') | new Location(name: 'a') | true
        footpathBetween('a', 'b') | new Location(name: 'c') | false
    }
}
