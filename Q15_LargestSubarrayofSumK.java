public class Q15_LargestSubarrayofSumK {
    public static int largestSubarraySumK(int[] arr, int k) {
        int i = 0, j = 0;
        int sum = 0;
        int maxLength = 0;

        while (j < arr.length) {
            sum += arr[j];

            while (sum > k && i <= j) {
                sum -= arr[i];
                i++;
            }

            if (sum == k) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
            j++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 1, 2, 3, 4};
        int k = 5;

        int result = largestSubarraySumK(arr, k);

        System.out.println(result);
    }
}
