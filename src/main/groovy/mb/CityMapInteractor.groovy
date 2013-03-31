package mb

import mb.mapping.StringToMapBuilder
import mb.mapping.search.DepthFirstSearch
import mb.mapping.traveller.Car
import mb.mapping.traveller.Traveller
import mb.mapping.traveller.Walker

class CityMapInteractor {

    def map

    CityMapInteractor(String routesAndLocations) {

        map = new StringToMapBuilder().buildCityFromString(routesAndLocations)
        map.searchAlgorithm = new DepthFirstSearch()
    }

    boolean isJourneyPossible(String startLocation, String destinationLocation, boolean onFoot) {

        Traveller traveller = onFoot ? new Walker() : new Car()
        map.isJourneyPossible(traveller, startLocation, destinationLocation)
    }
}
