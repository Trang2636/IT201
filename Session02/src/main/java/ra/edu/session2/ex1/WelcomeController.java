package ra.edu.session2.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
        @RequestMapping({"/","/welcome"})
        public String welcome() {
            return "welcome"; // tra ve ten view welcome.jsp
        }
}
