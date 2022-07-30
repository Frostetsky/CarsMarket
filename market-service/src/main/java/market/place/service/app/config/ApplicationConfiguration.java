package market.place.service.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;

@Configuration
public class ApplicationConfiguration {

    @Bean("page")
    public PageRequest pageRequest() {
        return PageRequest.of(0, 5);
    }
}
