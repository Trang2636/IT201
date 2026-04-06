package org.example.seasion2.bai1.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return null;
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class<?>[] { WebConfig.class };
        }

        @Override
        protected String[] getServletMappings() {
            return new String[] { "/" };
        }
    }

/*    phần 1 : phân tích
* DispatchServlet đang sử dụng /api/ nnhưng lại dùng /welcome nên sẽ bị lỗi 404
* DS đang nghe /api/*
Spring chỉ scan package @ComponentScan(basePackages = "com.demo.service") service nhưng WController nằm ở controller
-> Spring không tạo bean cho Controller
HandlerMapping không tìm thấy /welcome
 */


