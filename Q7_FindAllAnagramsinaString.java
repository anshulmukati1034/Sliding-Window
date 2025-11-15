import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q7_FindAllAnagramsinaString {
     public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;

        Map<Character, Integer> map = new HashMap<>();

        // Fill frequency of p in map
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int count = map.size();  // how many chars still need to match
        int window = p.length();

        while (right < s.length()) {
            char r = s.charAt(right);

            // If r exists in map → reduce its freq
            if (map.containsKey(r)) {
                map.put(r, map.get(r) - 1);
                if (map.get(r) == 0) {
                    count--;  // one char fully matched
                }
            }

            // If window size exceeded → shrink from left
            if (right - left + 1 > window) {
                char l = s.charAt(left);

                if (map.containsKey(l)) {
                    if (map.get(l) == 0) {
                        count++;  // one char becomes unmatched
                    }
                    map.put(l, map.get(l) + 1);
                }

                left++;
            }

            // If window matches and count == 0 → anagram found
            if (right - left + 1 == window && count == 0) {
                result.add(left);
            }

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams); // Output: [0, 6]
    }
}
