import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split("");

        Stack<String> lStack = new Stack<>();

        for(int i=0; i<s.length; i++) {
            lStack.push(s[i]);
        }
        int count = 0;
        int remain = 0;

        while(!lStack.isEmpty()){
            if(lStack.peek().equals(")")){
                lStack.pop();

                if(lStack.peek().equals("(")){
                    count += remain;
                    lStack.pop();
                }
                else{
                    remain++;
                    count++;
                }
            }else{
                lStack.pop();
                remain--;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
