import java.util.HashMap;
import java.util.Map;

public class Q13_MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        String ans="";
        int i=0,j=0;
        int minlen=Integer.MAX_VALUE;
        Map<Character,Integer>map=new HashMap<>();

        for(int k=0; k<t.length(); k++){
            char ch = t.charAt(k);
            map.put(ch,map.getOrDefault(ch,0)+1);
        } 
        int count=map.size();

        while(j<s.length()){
            char st = s.charAt(j);
            
            if(map.containsKey(st)){
                map.put(st,map.get(st)-1);
                if(map.get(st)==0){
                    count--;
                }
            }

            
            while (count == 0) {

                // update answer
                if (j - i + 1 < minlen) {
                    minlen = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            
                char s1 = s.charAt(i);
                if(map.containsKey(s1)){
                    map.put(s1,map.get(s1)+1);
                    if(map.get(s1)>0){
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return ans;
    } 

    public static void main(String[] args){
        String s="ADOBECODEBANC";
        String t="ABC";

        String result = minWindow(s,t);

        System.out.println(result);
    }
}
