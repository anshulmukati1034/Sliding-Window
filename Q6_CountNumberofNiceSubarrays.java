public class Q6_CountNumberofNiceSubarrays {

    public static int atMost(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int oddCount = 0;
        int ans = 0;

        while (right < nums.length) {

            // Add right element
            if (nums[right] % 2 == 1) {
                oddCount++;
            }

            // Shrink window if oddCount > k
            while (oddCount > k) {
                if (nums[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
            }

            // Count all valid subarrays ending at 'right'
            ans += (right - left + 1);

            right++;
        }

        return ans;
    }

      public static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k)); // Output: 2
    }
}
