import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> standard = new ArrayList<>();
        Stack<Integer> seqStack = new Stack<>();
        List<String> result = new ArrayList<>();

        for(int i=0; i<n; i++) {
            standard.add(Integer.parseInt(br.readLine()));
        }

        int num = 1;
        while(!standard.isEmpty()) {
            if(num > n && !seqStack.peek().equals(standard.get(0))) {
                break;
            }
            else if(!seqStack.isEmpty() && seqStack.peek().equals(standard.get(0))){
                result.add("-");
                standard.remove(0);
                seqStack.pop();

            }else{
                result.add("+");
                seqStack.add(num++);
            }
        }

        if(!standard.isEmpty()) {
            System.out.println("NO");
        }else{
            for(String s : result) {
                System.out.println(s);
            }
        }

    }
}
