package io.ryanliang.ryanet.service;

import io.ryanliang.ryanet.dao.NoteDaoInterface;
import io.ryanliang.ryanet.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NoteServiceImplementation implements NoteServiceInterface  {

    private NoteDaoInterface dao;

    @Autowired
    public void setDao(NoteDaoInterface dao) {

        this.dao = dao;
    }

    @Override
    public Note save(Note entity) {

        dao.persist(entity);
        return entity;
    }

    @Override
    public Note delete(Note entity) {

        dao.delete(entity);
        return entity;
    }
}
