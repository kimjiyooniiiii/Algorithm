import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] read = br.readLine().split(" ");

        Stack<Integer> stack = new Stack<>();

        int[] result = new int[n];

        for(int i=n-1; i>=0; i--) {
            int a = Integer.parseInt(read[i]);

            while(!stack.isEmpty()){
                if(stack.peek() > a) {
                    result[i] = stack.peek();
                    stack.push(a);
                    break;
                }else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result[i] = -1;
                stack.push(a);
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