import java.util.Deque;
import java.util.LinkedList;

public class Q9_SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx = 0;

        Deque<Integer> dq = new LinkedList<>();

        int i = 0, j = 0;

        while (j < n) {

            // REMOVE all smaller elements from BACK
            while (!dq.isEmpty() && dq.peekLast() < nums[j]) {
                dq.pollLast();
            }

            dq.offerLast(nums[j]); // add current element


            // window not formed yet
            if (j - i + 1 < k) {
                j++;
                continue;
            }

            // window size == k → record max
            result[idx++] = dq.peekFirst();


            // remove outgoing element
            if (dq.peekFirst() == nums[i]) {
                dq.pollFirst();
            }

            i++;
            j++;
        }

        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.print("Sliding Window Maximums are: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
