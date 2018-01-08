package io.ryanliang.ryanet.controller.api;

import io.ryanliang.ryanet.model.Note;
import io.ryanliang.ryanet.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/note")
public class NoteController {

    private NoteService noteService;

    @Autowired
    public void setNoteService(NoteService noteService) {

        this.noteService = noteService;
    }

    @GetMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Note getNoteWithID(@PathVariable Integer id) {

        return noteService.findOneByID(id);
    }

    @GetMapping(value = "list", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List getAllNotes(){

        return noteService.findAll();
    }
}

