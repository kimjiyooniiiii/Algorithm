import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] array = new int[26];

        String s = br.readLine();

        for(int i=0; i<s.length(); i++) {
            array[s.charAt(i) % 97] += 1;
        }

        for(int i=0; i<array.length; i++) {
            if(i != array.length-1){
                bw.write(array[i] + " ");
            }else{
                bw.write(String.valueOf(array[i]));
            }

        }
        bw.flush();
        bw.close();
    }
}
