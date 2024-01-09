import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String setting = scanner.nextLine();

        int totalBucket = Integer.valueOf(setting.split("\\s+")[0]);

        int[] bucket = new int[totalBucket];
        for(int i=0; i<bucket.length; i++) {
            bucket[i] = i+1;
        }
        int changeTimes = Integer.valueOf(setting.split("\\s+")[1]);

        while(changeTimes > 0) {
            String change = scanner.nextLine();

            int start = Integer.valueOf(change.split("\\s+")[0])-1;
            int end = Integer.valueOf(change.split("\\s+")[1])-1;

            bucket = reverse(bucket, start, end);
            changeTimes -= 1;
        }
        for (int i =0; i< bucket.length; i++) {
            System.out.print(bucket[i]);
            if (i != bucket.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static int[] reverse(int[] bucket, int start, int end) {
//        int[] newArray = new int[bucket.length];
//
//        for(int i=0; i<bucket.length; i++) {
//            if(start<=i && i<=end){
//                newArray[(end-start)-i] = bucket[i];
//            }
//            else{
//                newArray[i] = bucket[i];
//            }
//        }
//        return newArray;
        int index = 0;
        boolean[] isChecked = new boolean[bucket.length];
        for (int i = start; i <= end; i++) {
            int temp = bucket[i];
            if (bucket.length == 1 || !isChecked[temp - 1]) {
                bucket[i] = bucket[end - index];
                bucket[end - index] = temp;
                index++;
                if (bucket.length != 1) {
                    isChecked[temp - 1] = true;
                }
            }
        }

        return bucket;
    }
}