package mb.mapping.traveller

import mb.mapping.route.FootPath
import mb.mapping.route.Road
import mb.mapping.route.Route

class Walker implements Traveller {

    boolean canTravelOn(Route edge) {

        [Road, FootPath].contains(edge.class)
    }
}
