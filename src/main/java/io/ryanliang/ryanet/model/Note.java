package io.ryanliang.ryanet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
public class Note implements GenericModel {

    @Id
    @Column(name = "note_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "note_raw", nullable = false)
    private String raw;

    @Column(name = "note_html")
    private String html;

    @Column(name = "note_date_created")
    private LocalDateTime createdDate;

    @Column(name = "note_date_modified")
    private LocalDateTime modifiedDate;

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

    public String getHtml() {

        return html;
    }

    public void setHtml(String html) {

        this.html = html;
    }

    public LocalDateTime getCreatedDate() {

        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {

        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {

        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {

        this.modifiedDate = modifiedDate;
    }
}
