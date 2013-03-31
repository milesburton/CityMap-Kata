package mb.mapping.route

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import mb.mapping.Location

@ToString
@EqualsAndHashCode
class FootPath extends Route {

    Location locationA
    Location locationB

    @Override
    boolean canStartFrom(Location l) {
        [locationA, locationB].contains(l)
    }

    @Override
    boolean canReach(Location l) {
        [locationA, locationB].contains(l)
    }

    @Override
    List<Location> getDestinations() {
        [locationA, locationB]
    }
}
