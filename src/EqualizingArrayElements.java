//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.concurrent.Callable;
//
//public class EqualizingArrayElements {
//    public static void main(String[] args) {
//        List<Integer> arr  = new ArrayList<>();
//        int[] g = {1, 2,  3, 4, 5};
//        for(int i : g) arr.add(i);
//        int threshold = 3;
//        int d = 2;
//        System.out.println(minOperations(arr, threshold, d));
//    }
//    public static int minOperations(List<Integer> arr, int threshold, int d) {
//        int ct = 0;
//        int[] ar = new int[arr.size()];
//        Collections.sort(arr);
//        Collections.reverse(arr);
//        for(int i =0;i<arr.size();i++) ar[i] = arr.get(i);
//
//        int index = 0;
//
//        for(int i = 0;i<threshold-1;i++){
//            while(ar[index] != ar[index+1]){
//                if(ar[index] < ar[index+1]){
//                    ar[index+1]/=d;
//                    ct++;
//                }else{
//                    ar[index]/=d;
//                    ct += index+1;
//                }
//            }
//            System.out.println(Arrays.toString(ar));
//            index++;
//        }
//
//        return ct;
//
//    }
//}
