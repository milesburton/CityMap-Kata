City Map Kata
=========================
Developed with Gradle (Maven counterpart), Groovy 2.1 (Dynamic JVM based language)

To run this example please download gradle 1.1 and execute 'gradle run'

Implementation thoughts:
* Based on Depth first search (see https://github.com/milesburton/trains-java-tdd)
* Test driven using ATDD
* Each test was constructed to drive development by introducing new failures. Red (not compiling/failing), green (simplest solution to pass the test), refactor (clean up code)
* This is a brute force solution and doesn't take into account any shortest path algorithms
* The code is intended to be executed as the unit tests document.

Misc comments:
* I generally avoid using the constructor to setup our CityMap as tt tightly couples the city generation strategy to the object. We should rely on abstractions over concrete implementations.
* The CityMap 'interface' should be considered a facade with collaborators implementing each responsibility separately.
* Comments are to be avoided where possible, only in extreme cases should they be used. If our code does not describe the implementation future maintenance will be significantly harder
* A Boolean should never be used in method arguments. It implies a method is actually doing more than one thing breaking the SRP. Prefer either abstraction or separate naming.

Assumptions:
* You can begin at any location on the map
* The input string "routeAndLocations" is valid
* There are no orphan locations