package io.ryanliang.ryanet.model.response.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.ryanliang.ryanet.util.constant.NoteAPIs;

import java.time.Instant;

public class NoteBasicInfo {

    @JsonProperty(NoteAPIs.NOTE_ID)
    private Integer id;

    @JsonProperty(NoteAPIs.NOTE_NAME)
    private String name;

    @JsonProperty(NoteAPIs.NOTE_MODIFIED_DATE)
    private Instant modifiedDate;

    public NoteBasicInfo(Integer id, String name, Instant modifiedDate) {

        this.id = id;
        this.name = name;
        this.modifiedDate = modifiedDate;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Instant getModifiedDate() {

        return modifiedDate;
    }

    public void setModifiedDate(Instant modifiedDate) {

        this.modifiedDate = modifiedDate;
    }
}
