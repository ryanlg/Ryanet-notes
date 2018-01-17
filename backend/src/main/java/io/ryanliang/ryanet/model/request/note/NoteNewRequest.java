package io.ryanliang.ryanet.model.request.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.ryanliang.ryanet.util.constant.NoteAPIs;

public class NoteNewRequest {

    @JsonProperty(value = NoteAPIs.NOTES, required = true)
    private NoteNew[] newNotes;

    public NoteNew[] getNewNotes() {

        return newNotes;
    }
}
