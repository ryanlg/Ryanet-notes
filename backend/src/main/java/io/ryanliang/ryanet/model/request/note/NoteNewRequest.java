package io.ryanliang.ryanet.model.request.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.ryanliang.ryanet.util.constant.NoteAPIs;

import java.util.List;

public class NoteNewRequest {

    @JsonProperty(value = NoteAPIs.NOTES, required = true)
    private List<NoteNew> newNotes;

    public List<NoteNew> getNewNotes() {

        return newNotes;
    }
}
