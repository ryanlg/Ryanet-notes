package io.ryanliang.ryanet.dao;

import io.ryanliang.ryanet.model.persistence.Note;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.SingularAttribute;
import java.util.List;

@Repository
public class NoteDaoImplementation
        extends GenericDaoImplementation<Note, Integer>
        implements NoteDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Tuple> findByColumns(Attribute[] attributes) {

        CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
        CriteriaQuery<Tuple> criteria = criteriaBuilder.createTupleQuery();
        Root<Note> noteRoot = criteria.from(Note.class);

        Selection[] selections = new Selection[attributes.length];
        for (int i = 0; i < selections.length; i++) {

            if (attributes[i] instanceof SingularAttribute) {

                selections[i] = noteRoot.get((SingularAttribute) attributes[i]);
            }
        }

        TypedQuery<Tuple> query = this.getSession().createQuery(criteria);
        return query.getResultList();
    }
}
