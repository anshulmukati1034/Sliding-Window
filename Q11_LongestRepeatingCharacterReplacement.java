import java.util.HashMap;
import java.util.Map;

public class Q11_LongestRepeatingCharacterReplacement {
      public static int characterReplacement(String s, int k) {
        int i=0,j=0;
        int maxlength=0;
        int maxFreq=0;

        Map<Character,Integer> map = new HashMap<>();

        while(j<s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);

            maxFreq=Math.max(maxFreq,map.get(ch));

            int windowLen=j-i+1;

            if(windowLen - maxFreq > k){
                char charStart = s.charAt(i);
                map.put(charStart,map.get(charStart)-1);

                if(map.get(charStart) == 0){
                    map.remove(charStart);
                }
                i++;
            }
            maxlength=Math.max(maxlength,j-i+1);
            j++;
        }
        return maxlength;
    }

    public static void main(String args[]){
        String s = "AABABBA";
        int k=1;

        int maxlength = characterReplacement(s,k);

        System.out.println(maxlength);
    }
}
