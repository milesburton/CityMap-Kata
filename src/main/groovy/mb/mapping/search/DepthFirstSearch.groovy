package mb.mapping.search

import mb.mapping.Location
import mb.mapping.route.Route
import org.springframework.stereotype.Component

@Component
class DepthFirstSearch implements SearchAlgorithm {

    @Override
    boolean canTraverse(Set<Route> traversableRoutes, Location startLocation, Location destination) {

        Stack<Location> unvisitedLocations = new Stack<Location>();
        unvisitedLocations.add(startLocation)

        while (unvisitedLocations) {

            Location r = unvisitedLocations.pop()
            if (r == destination) {
                return true
            }

            unvisitedLocations.addAll(getNeighboursOf(traversableRoutes, r))
        }

        return false
    }

    private Set<Location> getNeighboursOf(Set<Route> traversableRoutes, Location startingLocation) {

        Set<Location> children = new HashSet<>()

        traversableRoutes
                .findAll { it.canStartFrom(startingLocation) }
        .each { children.addAll(it.destinations) }

        children - startingLocation
    }
}
