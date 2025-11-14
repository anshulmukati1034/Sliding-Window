import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Q4_CountDistinctElementsInEveryWindow {
    public static ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 0;

        while (j < arr.length) {

            
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

      
            if (j - i + 1 < k) {
                j++;
            }
           
            else if (j - i + 1 == k) {
                result.add(map.size());

                if (map.get(arr[i]) == 1) {
                    map.remove(arr[i]);
                } else {
                    map.put(arr[i], map.get(arr[i]) - 1);
                }

                
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        ArrayList<Integer> result = countDistinct(arr, k);

        System.out.println(result);
    }
}
