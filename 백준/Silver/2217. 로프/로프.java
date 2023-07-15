import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        StringBuilder sb = new StringBuilder();
        line = br.readLine();

        int all = Integer.valueOf(sb.append(line).toString());

        String line2;
        StringBuilder sb2 = new StringBuilder();
        for(int i=0; i<all; i++) {
            line2 = br.readLine();
            sb2.append(line2).append("\n");
        }
        String input = sb2.toString();
        br.close();

        String[] lines = input.split("\n");

        int[] arr = new int[lines.length];

        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.valueOf(lines[i]);
        }

        Arrays.sort(arr);
        int count = 2;
        List<Integer> list = new ArrayList<>();

        if(arr.length == 1){
            System.out.println(arr[0]);
        }else {
            for(int i=arr.length-1; i>=0; i--) {
                list.add(arr[i-1]*count);
                count++;
                if(count == arr.length+1){
                    break;
                }
            }
            System.out.println(Collections.max(list));
        }
    }
}
