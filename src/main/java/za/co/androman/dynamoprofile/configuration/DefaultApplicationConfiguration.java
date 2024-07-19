package za.co.androman.dynamoprofile.configuration;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableAutoConfiguration
@Configuration
@EnableJpaAuditing
public class DefaultApplicationConfiguration {
    private Mapper mapper;
    @Bean
    public Mapper dozerMapper(){
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        return mapper;
    }
}
