import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] array = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        String result = "";

        for(int i=0; i<array.length; i++ ) {
            if(array[i].equals("<")){
                while(!stack.isEmpty()){
                    result += stack.pop();
                }
                while(!array[i].equals(">")){
                    result += array[i];
                    i++;
                }
                result += array[i];
            }else if(array[i].equals(" ")){
                while(!stack.isEmpty()){
                    result += stack.pop();
                }
                result += array[i];
            }
            else {
                stack.push(array[i]);
            }
        }
        while(!stack.isEmpty()){
            result += stack.pop();

        }
        System.out.println(result);
    }
}
