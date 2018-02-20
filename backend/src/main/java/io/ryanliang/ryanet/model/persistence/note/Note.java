package io.ryanliang.ryanet.model.persistence.note;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @Column(name = "note_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "note_name")
    private String name;

    @Column(name = "note_raw", nullable = false)
    private String raw;

    @Column(name = "note_html")
    private String html;

    @Column(name = "note_excerpt")
    private String excerpt;

    @Column(name = "note_date_created", nullable = false)
    private Instant createdDate;

    @Column(name = "note_date_modified", nullable = false)
    private Instant modifiedDate;

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getRaw() {

        return raw;
    }

    public void setRaw(String raw) {

        this.raw = raw;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getHtml() {

        return html;
    }

    public void setHtml(String html) {

        this.html = html;
    }

    public Instant getCreatedDate() {

        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {

        this.createdDate = createdDate;
    }

    public Instant getModifiedDate() {

        return modifiedDate;
    }

    public void setModifiedDate(Instant modifiedDate) {

        this.modifiedDate = modifiedDate;
    }

    public String getExcerpt() {

        return excerpt;
    }

    public void setExcerpt(String excerpt) {

        this.excerpt = excerpt;
    }
}
