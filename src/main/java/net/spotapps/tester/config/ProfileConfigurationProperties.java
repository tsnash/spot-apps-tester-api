package net.spotapps.tester.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("tester")
public class ProfileConfigurationProperties {

    private String title = "Tester Application";
    private String swaggerTitle = "Swagger Docs";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSwaggerTitle() {
        return swaggerTitle;
    }

    public void setSwaggerTitle(String swaggerTitle) {
        this.swaggerTitle = swaggerTitle;
    }

}
