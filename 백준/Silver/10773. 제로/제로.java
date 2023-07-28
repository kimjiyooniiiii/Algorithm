
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int line = scan.nextInt();
        int[] array = new int[line];

        for(int i=0; i<line; i++){
            array[i] = scan.nextInt();
        }

        Stack<Integer> s = new Stack<>();
        // 배열을 돌면서
        for(int i=0; i<array.length; i++) {
            if(array[i] == 0) {
                s.pop();

            }else{
                s.push(array[i]);
            }
        }

        int sum = 0;
        while(!s.isEmpty()) {
            int a = s.pop();
            sum += a;
        }
        //for문을 돌리면 스택 사이즈가 줄어든다.... 이 실수 여러번 하네..

        System.out.println(sum);
    }
}
