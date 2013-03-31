package mb

import groovy.io.FileType
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import mb.argumentprocessing.ArgumentsMerge
import mb.usecase.ArgumentsValidatorInteractor
import org.apache.commons.lang.RandomStringUtils
import org.springframework.beans.factory.annotation.Autowired
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


    }

}
