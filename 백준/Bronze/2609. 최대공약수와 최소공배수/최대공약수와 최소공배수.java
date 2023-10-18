import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String numberLine = br.readLine();
        StringTokenizer st = new StringTokenizer(numberLine, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int div;
        //최대 공약수
        if(a>b){
            div = b;
        }else{
            div = a;
        }

        for(int i=div; i>0; i--){
            if(a%i == 0 && b%i == 0){
                bw.write(i + "\n");   //최대 공약수
                div = i;
                break;
            }
        }

        // 최소 공배수

        bw.write(String.valueOf(a/div * b/div * div));

        bw.flush();
        bw.close();
    }
}
