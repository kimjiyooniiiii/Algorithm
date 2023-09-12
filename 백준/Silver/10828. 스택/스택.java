import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            String order = br.readLine();

            if(order.contains("push")){
                stack.push(Integer.parseInt(order.substring(5)));
            }else if(order.equals("pop")) {
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.pop());
                }
            }else if(order.equals("size")) {
                System.out.println(stack.size());
            }else if(order.equals("empty")) {
                if(stack.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(order.equals("top")) {
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
