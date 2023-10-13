import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String read = br.readLine();
        StringTokenizer st = new StringTokenizer(read, " ");
        Stack<Top> stack = new Stack<>();

        int[] result = new int[n];

        for(int i=0; i<n; i++) {
            int a = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if(stack.peek().getHigh() > a) {
                    result[i] = stack.peek().getNum();
                    stack.push(new Top(i+1, a));
                    break;
                }else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result[i] = 0;
                stack.push(new Top(i+1, a));
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

class Top {
    private int num;
    private int high;

    public Top(int num, int high) {
        this.num = num;
        this.high = high;
    }
    public int getNum(){
        return num;
    }
    public int getHigh() {
        return high;
    }
}
