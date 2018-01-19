package io.ryanliang.ryanet.controller.api.v1;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ryanliang.markdownconverter.PandocMarkdownConverter;
import io.ryanliang.markdownconverter.error.MarkdownConverterException;
import io.ryanliang.ryanet.model.persistence.note.Note;
import io.ryanliang.ryanet.model.request.note.NoteNew;
import io.ryanliang.ryanet.model.request.note.NoteNewRequest;
import io.ryanliang.ryanet.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping("/api/v1/note")
public class NoteController {

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

    // --------------
    // * Get Methods *
    // --------------

    @GetMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Note getNoteWithID(@PathVariable Integer id) {

        return noteService.findOneByID(id);
    }

    // TODO: Add detailed response
    // TODO: Add incremental request
    @CrossOrigin // TODO: delete this
    @GetMapping(value = "/list", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List getAllNotes(){

        return noteService.findAllNoteBasicInfos();
    }

    // --------------
    // * POST Methods *
    // --------------

    @CrossOrigin // TODO: delete this
    @PostMapping(value = "/new")
    @ResponseBody
    public ResponseEntity postOrUpdateNewNote(HttpEntity<String> httpEntity) {

        String responseBody = httpEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();
        NoteNewRequest newRequest;
        try {

            newRequest = mapper.readValue(responseBody, NoteNewRequest.class);
        } catch (JsonParseException | JsonMappingException e) {

            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (IOException e) {

            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (newRequest != null) {

            NoteNew[] newNotes = newRequest.getNewNotes();
            if (newNotes.length > 0) {

                // TODO: Change this logic
                NoteNew firstNewNote = newNotes[0];

                Note note = new Note();
                String name = firstNewNote.getName();
                note.setName(name);

                String content = firstNewNote.getContent();
                note.setRaw(content);

                note.setCreatedDate(Instant.now());
                note.setModifiedDate(Instant.now());

                try {

                    note.setHtml(markdownConverter.convert(content));
                    return new ResponseEntity<>(note.getHtml(), HttpStatus.OK);
                }catch (MarkdownConverterException e) {

                    e.printStackTrace();
                    return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {

            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}

