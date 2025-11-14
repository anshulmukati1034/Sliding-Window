public class Q1_MaximumSumSubarraySizeK{

    public static int subArrayMaxiSum(int[] arr, int k){
        int i=0,j=0;
        int sum=0, maxiSum=0;

        while(j<arr.length){

            sum+=arr[j];

            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                maxiSum=Math.max(sum, maxiSum);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return maxiSum;
    }
    public static void main(String[] args){
        int[] arr = {2,1,5,1,3,2};
        int k=3;

        int result = subArrayMaxiSum(arr,k);

        System.out.println(result);
    }
}