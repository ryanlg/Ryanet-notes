package io.ryanliang.ryanet.service;

import io.ryanliang.ryanet.model.persistence.note.Note;
import io.ryanliang.ryanet.model.response.note.NoteBasicInfo;

import java.util.List;

public interface NoteService extends GenericService<Note, Integer> {

    List<NoteBasicInfo> findAllNoteBasicInfos();
}
