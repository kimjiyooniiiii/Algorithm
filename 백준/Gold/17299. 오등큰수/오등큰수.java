import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] read = br.readLine().split(" ");

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            int key = Integer.parseInt(read[i]);
            // key의 value값 증가
            if (map.containsKey(key)) {
                int count = map.get(key);
                map.put(key, ++count);
            } else {
                map.put(key, 1);
            }
        }

        int[] result = new int[n];

        for(int i=n-1; i>=0; i--) {
            int key = Integer.parseInt(read[i]);
            int value = map.get(key);

            while(!stack.isEmpty()){
                if(map.get(stack.peek()) > value) {
                    result[i] = stack.peek();
                    stack.push(key);
                    break;
                }else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result[i] = -1;
                stack.push(key);
            }
        }

        for(int i : result) {
            bw.write(i + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}