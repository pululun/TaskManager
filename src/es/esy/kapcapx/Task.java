package es.esy.kapcapx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "Task")
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {
    private String title;
    private String description;
    private Date date;
    private String contacts;
    private Boolean checked = false;

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

    public void setChecked(Boolean checked) {
        this.checked = checked;
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

    public Boolean getChecked() {
        return checked;
    }

    @Override
    public String toString() {
        return title + " " + description + " " + date + " " + contacts;
    }
}
