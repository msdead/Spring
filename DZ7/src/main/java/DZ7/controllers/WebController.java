package DZ7.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/public-data")
    public String publicPage() {
        return "public-data";
    }

    @GetMapping("/private-data")
    public String privatePage() {
        return "private-data";
    }
}
