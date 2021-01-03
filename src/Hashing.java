import java.util.*;

public class Hashing {
    // time: O(N), space: O(N)
    public static int findDuplicateElem(int[] arr) {
        HashSet<Integer> hash = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (hash.contains(arr[i])) return arr[i];
            hash.add(arr[i]);
        }
        return Integer.MIN_VALUE;
    }

    // O(N), O(N)
    // no duplicates
    public static boolean anagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        HashSet<Character> hash = new HashSet<>();

        for (int i = 0; i < s1.length(); i++) {
            hash.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!hash.contains(s2.charAt(i))) return false;
        }

        return true;
    }

    // with duplicates
    // ASCII characters
    // O(N),O(1)
    public static boolean anagrams2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] hash = new int[26];

        //O(N)
        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 97; // hash fn i: 97-97
//            hash[index] = hash[index] + 1;
            hash[index]++;
        }

        // O(N)
        for (int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i) - 97;
//            hash[index] = hash[index] - 1;
            hash[index]--;
        }

        // O(256)
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) return false;
        }

        return true;
    }

    public static void pairSum(int[] arr, int k) {
        HashSet<Integer> hash = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int y = k - x;

            if (hash.contains(y)) {
                System.out.println(x + " " + y);
                return;
            }
            hash.add(x);
        }
    }

    public static void getFrequency(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                int val = map.get(arr[i]);
                map.put(arr[i], ++val);
            }
        }

        print(map);
    }

    private static void print(HashMap<Integer, Integer> map) {
        // for each loop
        // iterator
        for (Integer key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
    }
}
