public class Q12_MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums,int k){
        int i=0,j=0;
        int zeroCount=0;
        int maxlength=0;

        while(j<nums.length){
            if(nums[j]==0){
                zeroCount++;
            }

            if(zeroCount > k){
                if(nums[i]==0){
                    zeroCount--;
                }
                i++;
            }

            maxlength=Math.max(maxlength, j-i+1);
            j++;
        }
        return maxlength;
    }

    public static void main(String[] args){
        int[] nums ={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;

        int maxlength = longestOnes(nums,k);

        System.out.println(maxlength);
    }
}
