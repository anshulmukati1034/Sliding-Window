import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q3_FirstNegativeInEveryWindowOfSizeK{
    public static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int n=arr.length;
        int i=0, j=0;
        
        while(j<n){
            if(arr[j]<0){
                queue.add(arr[j]);
            }
            if(j-i+1 < k){
                j++;
            }else if (j-i+1 == k){
                if(queue.isEmpty()){
                    list.add(0);
                }else{
                    list.add(queue.peek());
                    if(arr[i] == queue.peek()){
                        queue.remove();
                    }
                }
                i++;
                j++;
            }
          
        }
        return list;
    }

    public static void main(String[] args){
        int[] arr = {12,-1,-7,8,-15,30,16,28};
        int k=3;

        List<Integer> result = firstNegInt(arr,k);

        System.out.println(result);
    }
}