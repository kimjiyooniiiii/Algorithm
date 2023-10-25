import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String fac = facto(n).toString();
        int result=0;
        for(int i=fac.length()-1; i>=0; i--) {
            if(fac.charAt(i) != '0'){
                break;
            }else{
                result++;
            }
        }
        bw.write(result + "\n");
        bw.flush();

        /*Stack<Integer> stack = new Stack<>();
        for(int i=0; i<fac.length(); i++) {
            stack.push(Character.getNumericValue(fac.charAt(i)));
        }
        //System.out.println(stack);

        while(!stack.isEmpty()){
            if(stack.peek()!=0){
                bw.write(result + "\n");
                bw.flush();
                break;
            }else{
                result++;
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            bw.write(result + "\n");
            bw.flush();
        }
        bw.close();*/
    }


    public static BigInteger facto(int n) {
        if(n<=1){
            //System.out.println(n);
            return BigInteger.valueOf(1);
        }else{
            //System.out.println(n);
            return BigInteger.valueOf(n).multiply(facto(n-1));
        }
    }
}