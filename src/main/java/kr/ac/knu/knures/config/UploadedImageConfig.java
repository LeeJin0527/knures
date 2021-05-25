package kr.ac.knu.knures.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Log4j2
public class UploadedImageConfig implements WebMvcConfigurer {
    @Value("${uploadImage.path}")
    private String uploadImagePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/m_img/**")
                .addResourceLocations("file:" + uploadImagePath)
                .setCachePeriod(600);

        log.info("Serving static content from " + uploadImagePath);
    }
}
