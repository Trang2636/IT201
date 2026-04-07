
1. Trong MyWebAppInitializer.java, việc cấu hình "/api/*" khiến DispatcherServlet chỉ xử lý các request có
   URL bắt đầu bằng /api/. Vì vậy khi truy cập /welcome thì request  không đi qua DispatcherServlet mà bị Tomcat
   xử lý trực tiếp, dẫn đến lỗi 404. Với cấu hình này, DispatcherServlet chỉ lắng nghe các URL dạng /api/* như /api/welcome

2. Trong WebConfig.java, cấu hình @ComponentScan(basePackages = "com.demo.service") khiến Spring chỉ quét các class
   trong package com.demo.service. Trong khi đó, các class @Controller lại nằm ở com.demo.controller,
   nên Spring không tìm thấy Controller. Do đó không có mapping cho /welcome và dẫn đến lỗi 404

3. Nếu chỉ sửa lỗi mapping từ "/api/*" thành "/" mà không sửa @ComponentScan, thì ứng  dụng vẫn
   không chạy được. Vì dù request đã vào được DispatcherServlet, nhưng Spring  không tìm
   thấy @Controller để xử lý, nên vẫn bị lỗi 404.



