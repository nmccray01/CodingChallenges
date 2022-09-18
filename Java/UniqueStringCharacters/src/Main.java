import java.util.ArrayList;
import java.util.List;

public class Main {




    public static void main(String[] args){
        String string = "abcde";
        System.out.println(allUnique(string));
        System.out.println(allUniqueEasy(string));

    }

    //Intermediate difficulty: Without usage of additional datastructures and packages
    public static String allUnique( String string){
        int length = string.length();
        char[] chars = new char[length];

        for (int i = 0; i < length; i++){
            char a = string.charAt(i);
            if (!includes(chars, a)){
                chars[i] = a;
            } else {
                return "duplicates found!";
            }
        }

        return "all unique!";
    }

    public static boolean includes (char[] chars, char a){
        for (char b : chars){
            if (b == a){
                return true;
            }
        }

        return false;
    }

    //Easy: Usage of additional datastructures and java packages
    public static String allUniqueEasy(String string){
        int length = string.length();
        List chars = new ArrayList();

        for (int i = 0; i < length; i++){
            char a = string.charAt(i);
            if (!chars.contains(a)){
                chars.add(a);
            } else {
                return "duplicates found!";
            }
        }

        return "all unique!";

    }

}
