package strings.utils;

public class ABC {

    private static int firstIndex = 65;

    public static int getIndexByChar(int i){
        return i - firstIndex;
    }

    public static char getCharByIndex(int index){
        return (char) (index + firstIndex);
    }

}
