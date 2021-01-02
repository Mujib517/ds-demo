import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        boolean res = Hashing.anagrams2("abffg", "affbg");
        boolean res2 = Hashing.anagrams2("abc", "abd");
        System.out.println(res);
        System.out.println(res2);
    }
}
