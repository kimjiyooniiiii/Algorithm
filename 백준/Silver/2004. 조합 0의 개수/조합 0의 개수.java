import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");
        int n = Integer.parseInt(inputArray[0]);
        int r = Integer.parseInt(inputArray[1]);

        int twoResult = divideTwo(n) - (divideTwo(r) + divideTwo(n-r));
        int fiveResult = divideFive(n) - (divideFive(r) + divideFive(n-r));

        bw.write(Math.min(twoResult,fiveResult)+"");
        bw.flush();
        bw.close();
    }

    public static int divideTwo(int num) {
        int count = 0;
        while(num >= 2) {
            count += num / 2;
            num /= 2;
        }
        return count;
    }

    public static int divideFive(int num) {
        int count = 0;
        while(num >= 5) {
            count += num / 5;
            num /= 5;
        }
        return count;
    }
}