package ru.manerov.gb.actslog.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.manerov.gb.actslog.model.Act;
import ru.manerov.gb.actslog.service.ActService;

import java.util.List;

@Controller
@AllArgsConstructor
public class ActController {
    private final ActService actService;

    @GetMapping("/acts")
    public String findAll(Model model) {
        List<Act> acts = actService.findAll();


        model.addAttribute("acts", acts);
        return "act-list";
    }

    @GetMapping("/act-create")
    public String createActForm(Act ignoredAct) {
        return "act-create";
    }

    @PostMapping("/act-create")
    public String createAct(Act act) {
        actService.saveAct(act);
        return "redirect:/acts";
    }

    @GetMapping("/act-delete/{id}")
    public String deleteAct(@PathVariable("id") int id) {
        actService.deleteById(id);
        return "redirect:/acts";
    }

    @GetMapping("/act-update/{id}")
    public String getOneAct(@PathVariable("id") int id, Model model) {
        Act act = actService.getOneActByID(id);
        model.addAttribute("act", act);
        return "act-update";
    }

    @PostMapping("/act-update")
    public String updateAct(Act act) {
        actService.updateAct(act);
        return "redirect:/acts";
    }
}
