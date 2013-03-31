package mb.mapping

import mb.mapping.route.FootPath
import mb.mapping.route.Road
import mb.mapping.route.Route

class StringToMapBuilder {

    static String SYMBOL_FOR_FOOTPATH = '-'
    static String SYMBOL_FOR_ROAD = '='

    Map buildCityFromString(String routesAndLocations) {

        def routes = routesAndLocations.split(',').collect { def route ->

            isFootpath(route) ? buildFootpath(route) :
                buildRoad(route)

        }

        new Map(routes: routes)
    }

    private Route buildFootpath(String routesAndLocations) {

        List<Location> locations = extractLocations(routesAndLocations, SYMBOL_FOR_FOOTPATH)
        new FootPath(locationA: locations[0], locationB: locations[1])
    }

    private Route buildRoad(String routesAndLocations) {

        List<Location> locations = extractLocations(routesAndLocations, SYMBOL_FOR_ROAD)
        new Road(startLocation: locations[0], endLocation: locations[1])
    }

    private List<Location> extractLocations(String routesAndLocations, String token) {

        def locations = routesAndLocations.split(token).collect { def locationName ->
            new Location(name: locationName)
        }
        locations
    }

    private boolean isFootpath(String route) {
        route.contains(SYMBOL_FOR_FOOTPATH)
    }
}
