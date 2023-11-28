import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input =br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        if(n <= 1){
            bw.write(n+"");

        }else if(n == 2){
            if(m >= 9){
                bw.write("4");
            }else if(m%2==0){
                bw.write(m/2 + "");
            }else{
                bw.write(((m/2)+1)+"");
            }
        }else{
            if(m <= 4){
                bw.write(m+"");
            }else if(m==5 || m==6){
                bw.write("4");
            }else{
                bw.write((m-2)+"");
            }
        }
        bw.flush();
        bw.close();
    }

}