
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        while(true) {
            String s = scan.nextLine();

            if(s.equals(".")){
                break;
            }

            String n = "";

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' ||
                        s.charAt(i) == ')' ||
                        s.charAt(i) == '[' ||
                        s.charAt(i) == ']') {
                    n += s.charAt(i);
                }
            }

            boolean b = true;
            for (int i = 0; i < n.length(); i++) {

                if (n.charAt(i) == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {

                        stack.pop();
                    } else {
                        b = false;
                        break;
                    }
                } else if (n.charAt(i) == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        b = false;
                        break;
                    }
                } else {
                    stack.push(n.charAt(i));
                }
            }
            if (b && stack.isEmpty()) {
                System.out.println("yes");
                stack.clear();
            } else {
                System.out.println("no");
                stack.clear();
            }

        }
        scan.close();
    }
}
