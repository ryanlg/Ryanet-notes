package io.ryanliang.ryanet.util.constant;

public enum NoteAPIs implements Constant {

    NOTE("notes"),
    NOTE_NAME("name"),
    NOTE_CONTENT("content"),
    NOTE_MODIFIED_DATE("modified_date"),
    NOTE_CREATED_DATE("created_date");


    String value;

    NoteAPIs(String value) {
        this.value = value;
    }

    @Override
    public String getConstantValue() {

        return value;
    }
}
