package pl.polsl.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DateEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private LocalDateTime dateTime;

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public void setDateTime(LocalDateTime date) {
        dateTime = date;
    }

    private boolean isCompression;

    public boolean getCompression() {
        return isCompression;
    }

    public void setCompression(boolean compression) {
        isCompression = compression;
    }

    public DateEntry(LocalDateTime date) {
        dateTime = date;
    }

    public DateEntry() {

    }

    @Override
    public String toString() {
        return "DateEntry{" +
                "id=" + id +
                ", date=" + dateTime +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DateEntry)) {
            return false;
        }

        DateEntry other = (DateEntry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }

        return true;
    }
}