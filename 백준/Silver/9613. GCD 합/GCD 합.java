import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int taseCase = Integer.parseInt(br.readLine());

        for(int i=0; i<taseCase; i++) {
            String[] inputArray = br.readLine().split(" ");
            int n = Integer.parseInt(inputArray[0]);    //4
            long result = 0L;

            for(int j=1; j<=n; j++) {
                int count = 1;
                int diff = n-j;
                while(diff > 0){
                    result += gcd(Long.valueOf(inputArray[j]),Long.valueOf(inputArray[j+count])); //1,2  1,3  1,4
                    diff--;
                    count++;
                }
            }
            bw.write(result + "\n");
            bw.flush();
        }
        bw.close();

    }
    public static long gcd(long num1, long num2) {
        BigInteger big1 = BigInteger.valueOf(num1);
        BigInteger big2 = BigInteger.valueOf(num2);

        return big1.gcd(big2).longValue();
    }
}