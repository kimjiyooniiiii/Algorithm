import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int result = 0;

        String[] array = br.readLine().split(" ");

        for(int i=0; i<count; i++) {
            if(isDecimal(Integer.parseInt(array[i]))){
                result++;
            }
        }
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }

    public static boolean isDecimal(int num) {
        if(num == 1) {
            return false;
        }
        for(int i=2; i<num; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }

}