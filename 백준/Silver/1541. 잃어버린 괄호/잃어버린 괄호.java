import java.io.*;
import java.util.Stack;

public class Main {

    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //  String[] input = br.readLine().split(" ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String expression = br.readLine();
        int minus = 0;
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i) == '-'){
                minus = i;
                break;
            }
        }
        int result = 0;
        if(minus == 0){ // +로만 이루어졌을때
            result = plus(expression, 0, expression.length()-1);
        }else{
           // System.out.println(plus(expression, 0, minus-1));
      //      System.out.println(plus(expression, minus+1, expression.length()-1));
            result = plus(expression, 0, minus-1) - plus(expression, minus+1, expression.length()-1);
            //plus(expression, minus+1, expression.length()-1);
        }
        System.out.println(result);
    }

    public static int plus(String expression, int start, int end){
        Stack<Character> stack = new Stack<>();
       for(int i=end; i>=start; i--) {
            stack.push(expression.charAt(i));
       }
       String num = "0";
       int result = 0;
       while(!stack.isEmpty()) {
            char pop = stack.pop();
            if(pop != '+' && pop != '-') {
                num += pop;
            }else {
              //  System.out.println(num);
                result += Integer.valueOf(num);
                num = "";
            }
       }
       result += Integer.valueOf(num);
       return result;
    }
}
