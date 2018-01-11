package io.ryanliang.ryanet.controller.api.v1;

import io.ryanliang.ryanet.model.Note;
import io.ryanliang.ryanet.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/api/v1/note")
public class NoteController {

    private NoteService noteService;

    @Autowired
    public void setNoteService(NoteService noteService) {

        this.noteService = noteService;
    }

    // --------------
    // * Get Methods *
    // --------------

    @GetMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Note getNoteWithID(@PathVariable Integer id) {

        return noteService.findOneByID(id);
    }

    @GetMapping(value = "/list", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List getAllNotes(){

        return noteService.findAll();
    }

    // --------------
    // * POST Methods *
    // --------------

    @CrossOrigin
    @PostMapping(value = "/new")
    @ResponseBody
    public ResponseEntity postOrUpdateNewNote(@RequestBody Note[] notes) {

        System.out.println(notes[0].getRaw());
        return new ResponseEntity(HttpStatus.OK);
    }


}

