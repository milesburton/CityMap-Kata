package mb.mapping

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import mb.mapping.route.Route
import mb.mapping.traveller.Traveller
import mb.mapping.search.SearchAlgorithm

@EqualsAndHashCode
@ToString
class Map {

    ArrayList<Route> routes

    SearchAlgorithm searchAlgorithm

    boolean isJourneyPossible(Traveller traveller, String startLocation, String endLocation) {

        if (startLocation == endLocation) {
            return true
        }

        Location origin = new Location(name: startLocation)
        Location destination = new Location(name: endLocation)

        Set<Route> traversableRoutes = routes.findAll { traveller.canTravelOn(it) }

        searchAlgorithm.canTraverse(traversableRoutes, origin, destination)
    }
}
