import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /* long aTime = System.currentTimeMillis();*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 선언

        String sen = br.readLine();
        Stack<Character> lStack = new Stack<>();
        Stack<Character> rStack = new Stack<>();

        for(int i=0; i<sen.length(); i++) {
            lStack.push(sen.charAt(i));
        }

        int count = Integer.parseInt(br.readLine());

        for(int i=0; i<count; i++) {
            String s = br.readLine();

            if(s.contains("P")) {
                char c = s.charAt(2);
                lStack.push(c);
            }else if(s.equals("L")) {
                if(!lStack.isEmpty()){
                    rStack.push(lStack.pop());
                }

            }else if(s.equals("D")) {
                if (!rStack.isEmpty()) {
                    lStack.push(rStack.pop());
                }

            }else if(s.equals("B")) {
                if(!lStack.isEmpty()){
                    lStack.pop();
                }

            }
        }

        int lCount = lStack.size();
        for(int i=0; i<lCount; i++) {
            char a = lStack.pop();
            rStack.push(a);
        }

        int rCount = rStack.size();
        for(int i=0; i<rCount; i++) {
            bw.write(rStack.pop());
        }
        bw.newLine();
        bw.flush();

       /* long endTime = System.currentTimeMillis();
        bw.write("endTime: " + (endTime-aTime));

        bw.flush();*/
        bw.close();
    }
}
