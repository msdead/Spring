package DZ4.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import DZ4.domain.Visitor;
import DZ4.service.VisitorService;

import java.util.List;

@Controller
@AllArgsConstructor
public class VisitorController {
    private final VisitorService visitorService;

    @GetMapping("/visitors")
    public String viewVisitors(Model model) {
        List<Visitor> visitors = visitorService.allVisitors();
        model.addAttribute("visitors", visitors);
        return "visitors";
    }

    @PostMapping("/visitors")
    public String addProduct(Visitor visitor, Model model) {
        visitorService.addVisitor(visitor);
        List<Visitor> visitors = visitorService.allVisitors();
        model.addAttribute("visitors", visitors);
        return "visitors";
    }
}
