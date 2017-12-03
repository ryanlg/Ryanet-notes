package io.ryanliang.ryanet.controller;

import io.ryanliang.ryanet.model.Note;
import io.ryanliang.ryanet.service.NoteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
public class HomeController {

    private NoteServiceInterface noteService;

    @Autowired
    public void setNoteService(NoteServiceInterface noteService) {

        this.noteService = noteService;
    }

    @SuppressWarnings("SpringMVCViewInspection")
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");

        Note n = new Note();
        n.setRaw("<h/>");
        n.setCreatedDate(LocalDateTime.now());
        n.setModifiedDate(n.getCreatedDate());

        noteService.save(n);

        return "home";
    }

    @SuppressWarnings("SpringMVCViewInspection")
    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "home";
    }
}
