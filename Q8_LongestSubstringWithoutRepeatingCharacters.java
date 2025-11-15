import java.util.HashMap;
import java.util.Map;

public class Q8_LongestSubstringWithoutRepeatingCharacters {
      public static int lengthOfLongestSubstring(String s) {
       int i=0,j=0;
       Map<Character,Integer> map = new HashMap<>();
       int maxiLength=0;

       while(j<s.length()){

        char ch = s.charAt(j);

        map.put(ch,map.getOrDefault(ch,0)+1);

        while(map.get(ch)>1){
            char charStart = s.charAt(i);
            map.put(charStart,map.get(charStart)-1);
            if(map.get(charStart)==0){
                map.remove(charStart);
            }
            i++;
        }

        maxiLength = Math.max(maxiLength,j-i+1);
        j++;

       }
       return maxiLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println("Length of Longest Substring is:" + result);
    }
}
