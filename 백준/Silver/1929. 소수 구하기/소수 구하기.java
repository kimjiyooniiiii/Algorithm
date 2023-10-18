import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] array = br.readLine().split(" ");
        int start = Integer.parseInt(array[0]);
        int end = Integer.parseInt(array[1]);

        for(int i=start; i<=end; i++) {
            if(isDecimal(i)){
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static boolean isDecimal(int num) {
        if(num == 1) {
            return false;
        }
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }

}