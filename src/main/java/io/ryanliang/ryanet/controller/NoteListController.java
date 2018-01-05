package io.ryanliang.ryanet.controller;

import io.ryanliang.ryanet.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NoteListController {

    private NoteService noteService;

    @Autowired
    public void setNoteService(NoteService noteService) {

        this.noteService = noteService;
    }

    @RequestMapping("/list")
    public String getAllNotesToController(ModelMap modelMap){

        List notesList = noteService.findAll();
        modelMap.addAttribute("noteslist", notesList);

        return "thymeleaf/list.html";
    }
}
