package mb.mapping

import mb.mapping.traveller.Car
import mb.mapping.route.Route
import mb.mapping.traveller.Traveller
import mb.mapping.traveller.Walker
import mb.mapping.search.SearchAlgorithm
import spock.lang.Specification

import static helper.TestCityBuilder.buildCityWith
import static helper.TestFootpathBetweenBuilder.footpathBetween
import static helper.TestRoadBetweenBuilder.roadBetween

class MapSpec extends Specification {

    SearchAlgorithm mockSearchAlgorithm

    def 'setup'() {
        mockSearchAlgorithm = Mock(SearchAlgorithm)
    }

    def 'isJourneyPossible'() {

        given:
        Traveller traveller = new Walker()
        mb.mapping.Map city = buildCityWith(roadBetween('b', 'c'))
        city.searchAlgorithm = mockSearchAlgorithm

        when:
        def isJourneyPossible = city.isJourneyPossible(traveller, 'b', 'c')

        then:
        isJourneyPossible

        and:
        1 * mockSearchAlgorithm.canTraverse(new HashSet<Route>([roadBetween('b', 'c')]), new Location(name: 'b'), new Location(name: 'c')) >> true
        0 * _._
    }

    def 'isJourneyPossible with car'() {

        given:
        Traveller traveller = new Car()
        mb.mapping.Map city = buildCityWith(footpathBetween('b', 'c'))
        city.searchAlgorithm = mockSearchAlgorithm

        when:
        def isJourneyPossible = city.isJourneyPossible(traveller, 'b', 'c')

        then:
        !isJourneyPossible

        and:
        1 * mockSearchAlgorithm.canTraverse(new HashSet<Route>(), new Location(name: 'b'), new Location(name: 'c')) >> false
        0 * _._
    }
}
