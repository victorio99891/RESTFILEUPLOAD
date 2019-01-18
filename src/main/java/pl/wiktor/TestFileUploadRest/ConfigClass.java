package pl.wiktor.TestFileUploadRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class ConfigClass extends WebMvcConfigurationSupport {

    @Autowired
    Environment environment;

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        String DOWNLOAD_DIRECTORY = environment.getProperty("download.file.directory");
        registry.addResourceHandler("/srv_images/**").addResourceLocations(DOWNLOAD_DIRECTORY);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}
