package helper

import mb.mapping.route.FootPath
import mb.mapping.Location
import mb.mapping.route.Route

class TestFootpathBetweenBuilder {

    static Route footpathBetween(String start, String end){

        new FootPath(locationA: new Location(name: start), locationB: new Location(name: end))
    }
}
