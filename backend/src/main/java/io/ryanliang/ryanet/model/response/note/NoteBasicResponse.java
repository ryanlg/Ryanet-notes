package io.ryanliang.ryanet.model.response.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.ryanliang.ryanet.util.constant.NoteAPIs;

// Immutable
public class NoteBasicResponse {

    @JsonProperty(NoteAPIs.NOTES)
    private NoteBasicInfo[] infos;

    public NoteBasicInfo[] getInfos() {

        return infos;
    }

    public NoteBasicResponse(NoteBasicInfo[] infos) {

        this.infos = infos;
    }
}
