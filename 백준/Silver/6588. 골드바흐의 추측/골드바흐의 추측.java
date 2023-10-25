import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] array = new int[1000000];
        boolean pass;

        for(int i=2; i<array.length; i++) {
            array[i] = i;
        }

        for(int i=2; i<array.length; i++) {
            if(array[i] == 0){
                continue;
            }
            for(int j=i*2; j<array.length; j+=i){
                array[j] = 0;
            }
        }

        while(true) {
             pass = false;
             int n = Integer.parseInt(br.readLine());
             if(n == 0) {
                 break;
             }else{
                for(int i=2; i<=n/2; i++){
                    if(array[i]!=0){
                        if(array[n-i]!=0){
                            bw.write(n + " = " + i + " + " + (n-i)+"\n");
                            bw.flush();
                            pass = true;
                            break;
                        }
                    }

                }
                if(!pass){
                    bw.write("Goldbach's conjecture is wrong." + "\n");
                    bw.flush();
                }
             }
        }
    }
}