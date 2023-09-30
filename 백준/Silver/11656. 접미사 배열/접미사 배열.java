import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] array = new String[s.length()];
        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            stack.push(s.charAt(i));
        }

        for(int i=0; i<s.length(); i++) {
            String word = "";
            int j = i+1;
            while(j > 0) {
                if(!stack.isEmpty()){
                    char c = stack.pop();
                    word = c + word;
                    temp.push(c);
                    j--;
                }

            }
            while(!temp.isEmpty()){
                stack.push(temp.pop());
            }
            array[i] = word;
        }

        Arrays.sort(array);

        for(String a : array) {
            bw.write(a + "\n");
        }
        bw.flush();
        bw.close();
    }
}
