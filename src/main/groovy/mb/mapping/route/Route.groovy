package mb.mapping.route

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import mb.mapping.Location

@ToString
@EqualsAndHashCode
abstract class Route {

    abstract boolean canStartFrom(Location l)
    abstract boolean canReach(Location l)
    abstract List<Location> getDestinations()
}
