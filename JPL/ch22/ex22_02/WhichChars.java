package ch22.ex22_02;

import java.util.HashSet;
import java.util.Set;

public class WhichChars {

    public static void main(String[] args) {
        WhichChars wc = new WhichChars("Testing 1 2 3");
        System.out.println(wc);
    }

    private Set<Character> used = new HashSet<Character>();

    public WhichChars(String str) {
        for (int i = 0; i < str.length(); i++)
            used.add(str.charAt(i));
    }

    public String toString() {
        String desc = "[";
        for (Character c : used) {
            desc += c;
        }
        return desc + "]";
    }

}
