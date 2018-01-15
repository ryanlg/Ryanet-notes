package io.ryanliang.ryanet.service;

import io.ryanliang.ryanet.model.persistence.Note;
import io.ryanliang.ryanet.model.response.NoteBasicResponse;

import java.util.List;

public interface NoteService extends GenericService<Note, Integer> {

    List<NoteBasicResponse> findAllNoteBasicResponses();
}
