package io.ryanliang.ryanet.dao;

import io.ryanliang.ryanet.model.persistence.Note;

import javax.persistence.Tuple;
import javax.persistence.metamodel.Attribute;
import java.util.List;

public interface NoteDao extends GenericDao<Note, Integer> {

    List<Tuple> findByColumns(Attribute[] attributes);
}
