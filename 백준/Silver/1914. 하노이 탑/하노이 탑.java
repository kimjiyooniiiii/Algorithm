import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static BigInteger count = new BigInteger("2");
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        count = count.pow(n).subtract(new BigInteger("1"));

        if(n <= 20){
            hanoi(n,"1","2","3");
            bw.write(count + "\n");
            bw.flush();

            for(int i=0; i<list.size(); i++){
                bw.write(list.get(i) + "\n");
                bw.flush();
            }
        }else{
            bw.write(count + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static void hanoi(int n, String from, String temp, String to) {
        if(n==1){
                list.add(from + " " + to);
        }else{
            hanoi(n-1, from, to, temp);
                list.add(from + " " + to);
            hanoi(n-1, temp, from, to);
        }
    }

}