package vn.hcmute.baitap5.model;

import java.io.Serializable;

public class NotesModel implements Serializable {
    private int IdNote;
    private String nameNote;

    public NotesModel(int id, String nameNote) {
        this.nameNote = nameNote;
        this.IdNote = id;
    }

    public int getIdNote() {
        return IdNote;
    }

    public String getNameNote() {
        return nameNote;
    }

    public void setNameNote(String nameNote) {
        this.nameNote = nameNote;
    }
}

