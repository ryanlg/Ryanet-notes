package io.ryanliang.ryanet.controller;

import io.ryanliang.ryanet.model.Note;
import io.ryanliang.ryanet.service.NoteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.time.LocalDateTime;

@Controller
public class UploadController {

    private NoteServiceInterface noteService;

    @Autowired
    public void setNoteService(NoteServiceInterface noteService) {

        this.noteService = noteService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String showUploadForm() {

        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUploaded(@RequestParam("fileUpload") CommonsMultipartFile[] files) {

        if (files != null && files.length > 0) {

            for (CommonsMultipartFile file : files) {

                Note note = new Note();
                note.setRaw(new String(file.getBytes()));
                note.setCreatedDate(LocalDateTime.now());
                note.setModifiedDate(note.getCreatedDate());
                noteService.save(note);
            }
        }

        return "home";
    }
}
