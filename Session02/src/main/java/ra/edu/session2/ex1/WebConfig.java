package ra.edu.session2.ex1;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyWebAppInitializer.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // fix: bat toan bo url
    }


}
