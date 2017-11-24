package es.esy.kapcapx;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable{
    private String title;
    private String description;
    private Date date;
    private String contacts;

    Task (String title, String description, Date date, String contacts) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.contacts = contacts;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public String getContacts() {
        return contacts;
    }
}
