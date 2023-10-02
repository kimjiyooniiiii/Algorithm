import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int[] array = new int[n];
        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s," ");
        for(int i=0; i<array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int count = 1;

        for(int i=0; i<array.length; i++) {
            stack.push(array[i]);

            while(!stack.isEmpty()) {
                if(stack.peek() == count){
                    stack.pop();
                   // System.out.println("stack : " + stack + ", count : " + count);
                    count++;
                }else{
                    break;
                }
            }
            /*if(array[i] != count) {
                stack.push(array[i]);
                System.out.println("stack : " + stack + ", count : " + count);
            }else{
                System.out.println("stack : " + stack + ", count : " + count);
                count++;
            }*/
        }

        int size = stack.size();
        for(int i=0; i<size; i++) {
                if(stack.peek() != count) {
                    break;
                }else{
                    stack.pop();
                    count++;
                }
        }
        if(stack.isEmpty()){
            bw.write("Nice");
        }else{
            bw.write("Sad");
        }
        bw.flush();
        bw.close();
    }
}
