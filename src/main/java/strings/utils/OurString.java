package strings.utils;

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
        return ABC.getIndexByChar(value.charAt(value.length() - 1 - k));
    }

    @Override
    public String toString() {
        return "OurString{" +
            "value='" + value + '\'' +
            '}';
    }
}
