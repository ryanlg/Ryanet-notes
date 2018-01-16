package io.ryanliang.ryanet.dao;

import io.ryanliang.ryanet.model.persistence.note.Note;
import org.springframework.stereotype.Repository;

@Repository
public class NoteDaoImplementation
        extends GenericDaoImplementation<Note, Integer>
        implements NoteDao {


}
