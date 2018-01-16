package io.ryanliang.ryanet.model.response.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.ryanliang.ryanet.util.constant.NoteAPIs;

import java.time.LocalDateTime;

public class NoteBasicInfo {

    @JsonProperty(NoteAPIs.NOTE_ID)
    private Integer id;

    @JsonProperty(NoteAPIs.NOTE_NAME)
    private String name;

    @JsonProperty(NoteAPIs.NOTE_MODIFIED_DATE)
    private LocalDateTime modifiedDate;

    public NoteBasicInfo(Integer id, String name, LocalDateTime modifiedDate) {

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

    public LocalDateTime getModifiedDate() {

        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {

        this.modifiedDate = modifiedDate;
    }
}
