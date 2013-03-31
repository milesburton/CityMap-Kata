package mb

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.stereotype.Component

@Component
class Main {

    static void main(String[] args) {

        ApplicationContext ctx =
            new AnnotationConfigApplicationContext("mb");

        Main main = ctx.getBean(Main.class);

        main.run()

    }

    void run() {

        String cityWithRoads = 'a=b,b=c,c=a'
        CityMapInteractor detroitInterator = new CityMapInteractor(cityWithRoads)

        println '=============================================================================='
        println 'CityMap Kata'
        println '=============================================================================='

        println "City with roads: ${cityWithRoads}"
        println "Car can travel from a to c: ${detroitInterator.isJourneyPossible('a', 'c', false)}"
        println "Walker can travel from a to c: ${detroitInterator.isJourneyPossible('a', 'c', true)}"

        println '=============================================================================='

        String cityWithPaths = 'a-b,b-c,c-a'
        CityMapInteractor sheffieldInteractor = new CityMapInteractor(cityWithPaths)

        println "City with paths: ${cityWithPaths}"
        println "Car can travel from a to c: ${sheffieldInteractor.isJourneyPossible('a', 'c', false)}"
        println "Walker can travel from a to c: ${sheffieldInteractor.isJourneyPossible('a', 'c', true)}"

        println '=============================================================================='

        String cityWithRoadsAndPaths = 'a-b,b-c,c=a,a-x,x-a'
        CityMapInteractor londonInteractor = new CityMapInteractor(cityWithRoadsAndPaths)

        println "City with path and roads: ${cityWithRoadsAndPaths}"
        println "Car can travel from b to x: ${londonInteractor.isJourneyPossible('b', 'x', false)}"
        println "Walker can travel from a to x: ${londonInteractor.isJourneyPossible('a', 'x', true)}"
        println "Car can travel from c to a: ${londonInteractor.isJourneyPossible('c', 'a', false)}"

        println '=============================================================================='
        println 'Thank you - Miles Burton 2013'
        println '=============================================================================='

    }

}
