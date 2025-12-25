package net.spotapps.tester.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@Profile("local & !default")
public class LocalApplicationSwaggerConfig {

    final ProfileConfigurationProperties profileConfigurationProperties;

    public LocalApplicationSwaggerConfig(ProfileConfigurationProperties profileConfigurationProperties) {
        this.profileConfigurationProperties = profileConfigurationProperties;
    }

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title(profileConfigurationProperties.getTitle())
                .license(
                        new License().name("GNU General Public License v3.0").url("https://www.gnu.org/licenses/#GPL"));
    }

}
