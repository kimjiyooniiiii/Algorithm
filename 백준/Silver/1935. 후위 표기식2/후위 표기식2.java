import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Double> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split("");
        int[] numbers = new int[n];

        for(int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<array.length; i++) {
            if(!array[i].equals("/") && !array[i].equals("+") &&
                    !array[i].equals("-") && !array[i].equals("*")) {
                array[i] = String.valueOf(numbers[array[i].charAt(0) % 65]);
            }
        }

        for(int i=0; i< array.length; i++) {
            String s = array[i];
            if(s.equals("*")) {
                if(!stack.isEmpty()){
                    double x = 0, y = 0;
                    y =  stack.pop();
                    if(!stack.isEmpty()) {
                        x =  stack.pop();
                    }
                    stack.push(x * y);
                }
            }else if(s.equals("/")) {
                if(!stack.isEmpty()){
                    double x = 0, y = 0;
                    y =  stack.pop();
                    if(!stack.isEmpty()) {
                        x =  stack.pop();
                    }
                    stack.push(x / y);
                }
            }else if(s.equals("+")) {
                if(!stack.isEmpty()){
                    double x = 0, y = 0;
                    y =  stack.pop();
                    if(!stack.isEmpty()) {
                        x =  stack.pop();
                    }
                    stack.push(x + y);
                }
            }else if(s.equals("-")) {
                if(!stack.isEmpty()){
                    double x = 0, y = 0;
                    y =  stack.pop();
                    if(!stack.isEmpty()) {
                        x =  stack.pop();
                    }
                    stack.push(x - y);
                }
            }else{
                stack.push(Double.valueOf(s));
            }
        }
        bw.write(String.format("%.2f", stack.pop()));
        bw.flush();
        bw.close();
    }
}
