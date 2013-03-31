package mb.mapping.search

import mb.mapping.Location
import mb.mapping.route.Route

interface SearchAlgorithm {

    boolean canTraverse(Set<Route> traversableRoutes, Location startLocation, Location destination)
}