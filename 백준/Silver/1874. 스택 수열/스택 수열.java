
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] want = new int[n];
        for(int i=0 ;i<n; i++) {
            want[i] = scan.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        int a = 0;
        for(int i=1; i<=n; i++) {
            if(i == want[a]){
                stack.push(i);
                result.add("+");
                stack.pop();
                result.add("-");
                a++;
                //System.out.println(stack + ": " + result + " : " + a);

                while(!stack.isEmpty() && stack.peek() == want[a]){
                    result.add("-");
                    stack.pop();
                    a++;
                    //System.out.println(stack + ": " + result + " : " + a);
                }
            }else{
                stack.push(i);
                result.add("+");
               // System.out.println(stack + ": " + result);
            }
        }
        if(stack.isEmpty()){
            for(int i=0; i<result.size(); i++){
                System.out.println(result.get(i));
            }
            //System.out.println(result);
        }else{
            System.out.println("NO");
        }

    }
}
