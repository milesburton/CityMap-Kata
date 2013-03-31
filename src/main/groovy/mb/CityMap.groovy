package mb

class CityMap {

    ArrayList<Location> graph

    CityMap(String routesAndLocations) {

        Location startLocation = new Location(name: 'a')
        Location endLocation = new Location(name: 'b')
        BiDirectionalPath route = new BiDirectionalPath(startLocation: startLocation, endLocation: endLocation)
        graph = [startLocation, endLocation]
    }
}
