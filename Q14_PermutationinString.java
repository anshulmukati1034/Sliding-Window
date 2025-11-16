import java.util.HashMap;
import java.util.Map;

public class Q14_PermutationinString {
        public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        // Fill frequency of s1
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int count = map.size();      // Kitne characters abhi match hone baaki hain
        int window = s1.length();    // Fixed window

        while (right < s2.length()) {

            char r = s2.charAt(right);

            // RIGHT pointer add kare
            if (map.containsKey(r)) {
                map.put(r, map.get(r) - 1);

                if (map.get(r) == 0) {
                    count--;   // ek character completely match ho gaya
                }
            }

            // Window bada ho gaya → shrink
            if (right - left + 1 > window) {
                char l = s2.charAt(left);

                if (map.containsKey(l)) {

                    if (map.get(l) == 0) {
                        count++;   // ek character phir unmatched ho gaya
                    }

                    map.put(l, map.get(l) + 1);
                }

                left++;
            }

            // If window size matches AND count == 0 → permutation found
            if (right - left + 1 == window && count == 0) {
                return true;
            }

            right++;
        }

        return false;
    }

    public static void main(String[] args){
        String s1="ab";
        String s2="eidbaooo";

        boolean result = checkInclusion(s1,s2);

        System.out.println(result);
    }

}
