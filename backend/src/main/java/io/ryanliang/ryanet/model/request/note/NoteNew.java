package io.ryanliang.ryanet.model.request.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.ryanliang.ryanet.util.constant.NoteAPIs;

import java.time.LocalDateTime;

public class NoteNew {

    @JsonProperty(value = NoteAPIs.NOTE_ID, required = true)
    private Integer id;

    @JsonProperty(value = NoteAPIs.NOTE_NAME, required = true)
    private String name;

    @JsonProperty(value = NoteAPIs.NOTE_CONTENT, required = true)
    private String content;

    @JsonProperty(value = NoteAPIs.NOTE_CREATED_DATE)
    private LocalDateTime createdDate;
}
