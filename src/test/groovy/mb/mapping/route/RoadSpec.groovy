package mb.mapping.route

import mb.mapping.Location
import spock.lang.Specification
import spock.lang.Unroll

import static helper.TestRoadBetweenBuilder.roadBetween

class RoadSpec extends Specification {

    @Unroll
    def 'canStartFrom #canStartFrom #origin when #route '() {

        expect:
        route.canStartFrom(origin) == canStartFrom

        where:
        route                 | origin            | canStartFrom
        roadBetween('a', 'b') | new Location(name: 'a') | true
        roadBetween('a', 'b') | new Location(name: 'b') | false
    }

    @Unroll
    def 'canReach #canStartFrom #destination when #route '() {

        expect:
        route.canReach(destination) == isReachable

        where:
        route                 | destination            | isReachable
        roadBetween('a', 'b') | new Location(name: 'b') | true
        roadBetween('a', 'b') | new Location(name: 'a') | true
        roadBetween('a', 'b') | new Location(name: 'c') | false
    }



}
