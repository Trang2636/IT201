package org.example.seasion7_bai5.config;
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    private static final String TMP_LOCATION = "E:/upload_img_java/";
//    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024;
//    private static final long MAX_REQUEST_SIZE = 10 * 1024 * 1024;

    // bai 5: gioi han kich thuoc 10MB
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024;
    private static final long MAX_REQUEST_SIZE = 15 * 1024 * 1024;
    private static final int FILE_SIZE_THRESHOLD = 1024 * 1024;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement(
                        TMP_LOCATION,
                        MAX_FILE_SIZE,
                        MAX_REQUEST_SIZE,
                        FILE_SIZE_THRESHOLD
                )
        );
    }

}
