package pl.wiktor.TestFileUploadRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"pl.wiktor.*"})
@SpringBootApplication
public class TestFileUploadRestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TestFileUploadRestApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TestFileUploadRestApplication.class);
    }


}

