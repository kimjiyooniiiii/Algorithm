import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int e = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);

        while(e != s || s != m || m != e){
            int min = Math.min(Math.min(e,s),m);
            if(min == e){
                e += 15;
            }else if(min == s){
                s += 28;
            }else{
                m += 19;
            }
        }
        System.out.println(e);
    }
}