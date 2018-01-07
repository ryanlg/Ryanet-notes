package io.ryanliang.ryanet.controller;

import io.ryanliang.ryanet.model.Note;
import io.ryanliang.ryanet.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/note")
public class NoteController {

    private NoteService noteService;

    @Autowired
    public void setNoteService(NoteService noteService) {

        this.noteService = noteService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getNoteWithID(@PathVariable Integer id, ModelMap modelMap) {

        Note requestedNote = noteService.findOneByID(id);
        modelMap.addAttribute("requestedNote", requestedNote);

        return "";
    }
}

