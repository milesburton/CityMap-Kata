package mb.mapping.search

import mb.mapping.Location
import mb.mapping.route.Route
import spock.lang.Specification
import spock.lang.Unroll

import static helper.TestFootpathBetweenBuilder.footpathBetween
import static helper.TestRoadBetweenBuilder.roadBetween

class DepthFirstSearchSpec extends Specification {

    DepthFirstSearch depthFirstSearch

    def 'setup'() {
        depthFirstSearch = new DepthFirstSearch()
    }

    @Unroll
    def 'given #routes canTraverse between #locationA and #locationB: #isPossible'() {

        given:
        def routeSet = new HashSet<Route>(routes)
        def origin = new Location(name: startLocation)
        def destination = new Location(name: endLocation)

        expect:
        depthFirstSearch.canTraverse(routeSet, origin, destination) == isPossible

        where:
        routes                                                 | startLocation | endLocation | isPossible
        [roadBetween('b', 'c')]                                | 'b'           | 'b'         | true
        [roadBetween('b', 'c')]                                | 'b'           | 'c'         | true
        [roadBetween('b', 'c')]                                | 'c'           | 'b'         | false
        [footpathBetween('b', 'c')]                            | 'b'           | 'c'         | true
        [footpathBetween('b', 'c')]                            | 'c'           | 'b'         | true
        [footpathBetween('b', 'c'), footpathBetween('c', 'd')] | 'c'           | 'd'         | true
    }
}
