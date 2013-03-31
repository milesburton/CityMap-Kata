package helper

import mb.mapping.Map
import mb.mapping.route.Route

class TestCityBuilder {

    static Map buildCityWith(Route... route){

        new Map(routes: route)
    }
}
