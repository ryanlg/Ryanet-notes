package io.ryanliang.ryanet.controller;

import io.ryanliang.markdownconverter.PandocMarkdownConverter;
import io.ryanliang.markdownconverter.error.MarkdownConverterException;
import io.ryanliang.ryanet.model.Note;
import io.ryanliang.ryanet.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class UploadController {

    private NoteService noteService;
    private PandocMarkdownConverter markdownConverter;

    @Autowired
    public void setNoteService(NoteService noteService) {

        this.noteService = noteService;
    }

    @Autowired
    public void setMarkdownConverter(PandocMarkdownConverter markdownConverter) {

        this.markdownConverter = markdownConverter;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String showUploadForm() {

        return "upload.jsp";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView handleFileUploaded(@RequestParam("fileUpload") CommonsMultipartFile[]
                                                       files, ModelAndView modelAndView) {

        String s = "";
        if (files != null && files.length > 0) {

            for (CommonsMultipartFile file : files) {

                Note note = new Note();
                note.setRaw(new String(file.getBytes()));
                note.setCreatedDate(LocalDateTime.now());
                note.setModifiedDate(note.getCreatedDate());

                try {

                    note.setHtml(markdownConverter.convert(note.getRaw()));
                } catch (MarkdownConverterException e) {

                    e.printStackTrace();
                }

                s = note.getHtml();
                noteService.save(note);
            }
        }

        modelAndView.setViewName("uploaded.jsp");
        modelAndView.addObject("greeting", s);
        System.out.println(s);

        return modelAndView;
    }
}
