package mb.mapping.traveller

import mb.mapping.route.Road
import mb.mapping.route.Route

class Car implements Traveller{

    @Override
    boolean canTravelOn(Route edge) {
        [Road].contains(edge.class)
    }
}
