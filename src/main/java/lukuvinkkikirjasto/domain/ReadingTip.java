package lukuvinkkikirjasto.domain;

import java.util.Objects;

public class ReadingTip {
    private int id;
    private String header;
    private String description;
    private boolean read;
    
    public ReadingTip(int id, String title, String description) {
        this.id = id;
        this.header = title;
        this.description = description;
        this.read = false;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }
    
    public boolean getReadStatus() {
        return read;
    }
    
    public int getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.header = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setReadStatus(Boolean read) {
        this.read = read;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReadingTip other = (ReadingTip) obj;
        if (!Objects.equals(this.header, other.header)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return ("ID: " + this.id + "\nHeader: " + this.header + "\nDescription: " + this.description);
    }
    
}
