package helper

import mb.mapping.Location
import mb.mapping.route.Road
import mb.mapping.route.Route

class TestRoadBetweenBuilder {

    static Route roadBetween(String start, String end) {

        new Road(startLocation: new Location(name: start), endLocation: new Location(name: end))
    }
}
