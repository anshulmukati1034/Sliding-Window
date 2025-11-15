public class Q5_MaximumNumberofVowelsinaSubstringofGivenLength {

    public static boolean isVowel(char c) {
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }

    public static int maxVowels(String s, int k) {
        int i=0,j=0;
        int currentCount=0;
        int maxCount=0;

        while(j<s.length()){
            
            if(isVowel(s.charAt(j))){
                currentCount++;
            }

            if(j-i+1 > k){
                if(isVowel(s.charAt(i))){
                    currentCount--;
                }
                i++;
            }

            if(j-i+1 == k){
                maxCount=Math.max(maxCount,currentCount);
            }
            j++;

        }   
        return maxCount;
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k)); // Output: 3
    }
}
