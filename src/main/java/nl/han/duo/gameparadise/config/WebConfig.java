package nl.han.duo.gameparadise.config;

import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.CorsRegistry;
        import org.springframework.web.servlet.config.annotation.EnableWebMvc;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
class WebConfig extends WebMvcConfigurerAdapter {

    private final Logger log = LoggerFactory.getLogger(WebConfig.class);

    @Value("${domainsList: not configured}")
    private String domains;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.debug("Cors domain: {}", domains);
        registry.addMapping("/**")
                .allowedOrigins(domains.split(","));
    }
}