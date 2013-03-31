package mb.mapping.route

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import mb.mapping.Location

@ToString
@EqualsAndHashCode
class Road extends Route  {

    Location startLocation
    Location endLocation

    @Override
    boolean canStartFrom(Location l) {

        startLocation == l
    }

    @Override
    boolean canReach(Location l) {
       [startLocation, endLocation].contains(l)
    }

    @Override
    List<Location> getDestinations() {
        [endLocation]
    }
}
