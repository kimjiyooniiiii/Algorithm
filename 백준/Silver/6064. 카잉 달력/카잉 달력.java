import java.io.*;
import java.math.BigInteger;

public class Main {
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        if(t != 0){
            for(int i=0; i<t; i++){
                String[] line = br.readLine().split(" ");
                int m = Integer.parseInt(line[0]);
                int n = Integer.parseInt(line[1]);
                int x = Integer.parseInt(line[2]);
                int y = Integer.parseInt(line[3]);

                int result = calYear(m,n,x,y);
                bw.write(result + "\n");
                bw.flush();
            }
        }
        bw.close();

    }

    public static int calYear(int m, int n, int x, int y) {
        BigInteger b1 = BigInteger.valueOf(m);
        BigInteger b2 = BigInteger.valueOf(n);
        BigInteger gcdB = b1.gcd(b2);
        int gcd =  gcdB.intValue();

        int end = (m*n) / gcd;

        int xx = x;
        int yy = y;

        while(xx <= end && yy <= end){
            if(xx == yy){
                return xx;
            }else{
                int min = Math.min(xx,yy);
                if(min == xx){
                    xx += m;
                }else{
                    yy += n;
                }
            }
        }

        return -1;
    }

}