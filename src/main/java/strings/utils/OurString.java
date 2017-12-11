package strings.utils;

import java.util.Objects;

public class OurString {

    private String value;

    public OurString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int key(int k){
        if(value.length() <= k || k < 0) return -1;
        return ABC.getIndexByChar(value.charAt(k));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OurString ourString = (OurString) o;
        return Objects.equals(value, ourString.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "OurString{" +
            "value='" + value + '\'' +
            '}';
    }
}
