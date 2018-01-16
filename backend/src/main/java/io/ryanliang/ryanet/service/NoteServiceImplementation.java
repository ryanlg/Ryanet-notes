package io.ryanliang.ryanet.service;

import io.ryanliang.ryanet.dao.NoteDao;
import io.ryanliang.ryanet.model.persistence.note.Note;
import io.ryanliang.ryanet.model.persistence.note.Note_;
import io.ryanliang.ryanet.model.response.note.NoteBasicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import javax.persistence.metamodel.Attribute;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class NoteServiceImplementation implements NoteService {

    private NoteDao dao;

    @Autowired
    public void setDao(NoteDao dao) {

        this.dao = dao;
    }

    @Override
    public Note save(Note entity) {

        dao.persist(entity);
        return entity;
    }

    @Override
    public List<Note> findAll() {

        return dao.findAll();
    }

    @Override
    public Note delete(Note entity) {

        dao.delete(entity);
        return entity;
    }

    @Override
    public Note findOneByID(Integer id) {

        return dao.findOneByID(id);
    }

    @Override
    public List<NoteBasicInfo> findAllNoteBasicResponses() {

        List<Tuple> found = dao.findTuplesByColumns(
                new Attribute[]{Note_.id, Note_.name, Note_.modifiedDate});

        List<NoteBasicInfo> resultList = new ArrayList<>(found.size());
        for (Tuple tuple : found) {

            Integer id = (Integer) tuple.get(0);
            String name = (String) tuple.get(1);
            LocalDateTime modifiedDate = (LocalDateTime) tuple.get(2);

            NoteBasicInfo basicResponse = new NoteBasicInfo(id, name, modifiedDate);
            resultList.add(basicResponse);
        }

        return resultList;
    }
}
