import java.util.HashMap;
import java.util.Map;


public class Q10_LongestSubstringWithKUnique {
    public static int LongestString(String str, int k){
        int i=0,j=0;
        int maxlength=0;
        Map<Character,Integer> map = new HashMap<>();
        
        while(j<str.length()){
            char ch =str.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);

            if(map.size()<k){
                j++;
            }
            else if(map.size()==k){
                maxlength = Math.max(maxlength,j-i+1);
                j++;
            }
            else if(map.size()>k){
                while(map.size()>k){
                    char charStart = str.charAt(i);
                    map.put(charStart,map.get(charStart)-1);
                    if(map.get(charStart)==0){
                        map.remove(charStart);
                    }
                    i++;
                }
                j++;
            }

        }
        return maxlength;
    }

    public static void main(String[] args) {
        String str = "aabacbebebe";
        int k = 3;
        int result = LongestString(str, k);
        System.out.println("Length of Longest Substring with K Unique Characters is: " + result);
    }
}
