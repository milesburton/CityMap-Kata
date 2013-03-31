package mb.mapping.traveller

import mb.mapping.route.Route

interface Traveller {

    boolean canTravelOn(Route edge)
}
