package es.upm.miw.apaw_ep_themes.documents;

public class InstrumentType {
    private String type;
    private boolean hasstrings;

    public InstrumentType(String type, boolean hasstrings) {
        this.type = type;
        this.hasstrings = hasstrings;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHasstrings() {
        return hasstrings;
    }

    public void setHasstrings(boolean hasstrings) {
        this.hasstrings = hasstrings;
    }

    @Override
    public String toString() {
        return "InstrumentType{" +
                "type='" + type + '\'' +
                ", hasstrings=" + hasstrings +
                '}';
    }
}
