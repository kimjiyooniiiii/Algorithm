import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=5; i<=n; i+=5) {
            int num = i;
            while(num % 5 == 0){
                count++;
                num/=5;
            }
        }
        bw.write(count+" ");
        bw.flush();
        bw.close();

        /*String[] inputArray = br.readLine().split(" ");

        BigInteger first = new BigInteger(inputArray[0]);
        BigInteger second = new BigInteger(inputArray[1]);



        //int count = facto(first) / (facto(first-second) * facto(second));
        System.out.println(combination(first, second));*/
    }

/*    public static BigInteger combination(BigInteger n, BigInteger r) {
        BigInteger one = new BigInteger("1");

        if(n.equals(r) || r.equals(new BigInteger("0"))){
            return one;
        }else{
            return combination(n.subtract(one), r.subtract(one)).add(
                    combination(n.subtract(one), r));
        }
        //return facto(n).divide(facto(r).multiply(facto(n.subtract(r))));
    }

    public static BigInteger facto(BigInteger n){
        BigInteger one = new BigInteger("1");

        if(n.compareTo(one) == 0 || n.compareTo(one)==-1) { // 1보다 작거나 같으면
            return one;
        }else{
            return n.multiply(facto(n.subtract(one)));
        }
    }*/
}