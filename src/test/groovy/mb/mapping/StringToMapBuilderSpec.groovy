package mb.mapping

import mb.mapping.StringToMapBuilder
import spock.lang.Specification

import static helper.TestRoadBetweenBuilder.roadBetween
import static helper.TestCityBuilder.buildCityWith
import static helper.TestFootpathBetweenBuilder.footpathBetween

class StringToMapBuilderSpec extends Specification {

    StringToMapBuilder cityBuilder

    def 'setup'() {
        cityBuilder = new StringToMapBuilder()
    }

    def 'build city with foot path between a-b'() {

        when:
        mb.mapping.Map actualCityMap = cityBuilder.buildCityFromString('a-b')

        then:
        actualCityMap == buildCityWith(footpathBetween('a', 'b'))
    }

    def 'build city with footpath between c-b'() {

        when:
        mb.mapping.Map actualCityMap = cityBuilder.buildCityFromString('c-b')

        then:
        actualCityMap == buildCityWith(footpathBetween('c', 'b'))
    }

    def 'build city with road between a=b'() {

        when:
        mb.mapping.Map actualCityMap = cityBuilder.buildCityFromString('a=b')

        then:
        actualCityMap == buildCityWith(roadBetween('a', 'b'))
    }

    def 'build city with roads a=b, b=c'(){

        when:
        mb.mapping.Map actualCityMap = cityBuilder.buildCityFromString('a=b,b=c')

        then:
        actualCityMap == buildCityWith(roadBetween('a', 'b'), roadBetween('b', 'c'))
    }

    def 'build city with varied path between a=b, b-c'(){

        when:
        mb.mapping.Map actualCityMap = cityBuilder.buildCityFromString('a=b,b-c')

        then:
        actualCityMap == buildCityWith(roadBetween('a', 'b'), footpathBetween('b', 'c'))
    }
}
