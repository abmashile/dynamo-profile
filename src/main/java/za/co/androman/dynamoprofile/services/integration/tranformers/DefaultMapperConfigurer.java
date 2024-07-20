package za.co.androman.dynamoprofile.services.integration.tranformers;

import dev.akkinoc.spring.boot.orika.OrikaMapperFactoryConfigurer;
import ma.glasnost.orika.MapperFactory;
import za.co.androman.dynamoprofile.services.controller.integration.AssessmentQuestionAnswer;

public class DefaultMapperConfigurer implements OrikaMapperFactoryConfigurer {
    @Override
    public void configure(MapperFactory orikaMapperFactory) {
       orikaMapperFactory.classMap(AssessmentQuestionAnswer.class, za.co.androman.dynamoprofile.entities.AssessmentQuestionAnswer.class)
                .field("isCorrect", "isCorrect")
                .byDefault()
                .register();
    }
}
