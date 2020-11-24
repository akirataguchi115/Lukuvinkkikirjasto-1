package lukuvinkkikirjasto.domain;

import java.util.Objects;

public class ReadingTip {
    private String header;
    private String description;
    
    public ReadingTip(String title, String description) {
        this.header = title;
        this.description = description;
    }

    public String getTitle() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.header = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.header);
        hash = 79 * hash + Objects.hashCode(this.description);
        return hash;
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
    
    
}
