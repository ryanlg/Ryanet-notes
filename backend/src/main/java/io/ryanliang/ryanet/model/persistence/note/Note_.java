package io.ryanliang.ryanet.model.persistence.note;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Note.class)
public abstract class Note_ {

	public static volatile SingularAttribute<Note, LocalDateTime> createdDate;
	public static volatile SingularAttribute<Note, String> name;
	public static volatile SingularAttribute<Note, LocalDateTime> modifiedDate;
	public static volatile SingularAttribute<Note, String> raw;
	public static volatile SingularAttribute<Note, String> html;
	public static volatile SingularAttribute<Note, Integer> id;

}

