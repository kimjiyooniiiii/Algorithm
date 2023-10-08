import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        Stack<Study> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s," ");

            if(st.nextToken().equals("1")){
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken())-1;

                if(time > 0) {  // 과제 남음
                    stack.push(new Study(score, time));
                }else{
                    sum += score;
                }
            }else{
                if(!stack.isEmpty()) {
                    stack.peek().minus();
                    if(stack.peek().get()[1] == 0){
                        sum += stack.pop().get()[0];
                    }
                }
            }

        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}

class Study {
    private int[] array = new int[3];

    public Study(int score, int time) {
        this.array[0] = score;
        this.array[1] = time;
    }

    public int[] get() {
        return array;
    }

    public void minus(){
        this.array[1] -= 1;
    }
}

