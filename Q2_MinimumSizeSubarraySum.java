public class Q2_MinimumSizeSubarraySum {
     public static int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0;
        int miniMum=Integer.MAX_VALUE;
        int sum=0;

        while(j<nums.length){
            sum+=nums[j];

            while(sum>=target){
                miniMum=Math.min(miniMum,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return (miniMum == Integer.MAX_VALUE) ? 0 : miniMum;
    }

    public static void main(String[] args){
        int[] arr = {2,3,1,2,4,3};
        int target=7;

        int result = minSubArrayLen(target,arr);

        System.out.println(result);
    }
}
