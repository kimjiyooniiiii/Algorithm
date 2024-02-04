import java.io.*;
import java.util.Arrays;

public class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int l, c;

    public static String[] result;

    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        l = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        result = new String[l];
        isVisited = new boolean[c];

        String[] charArray = br.readLine().split(" ");
        Arrays.sort(charArray);

        recur(0, charArray, 'A');
        bw.flush();
        bw.close();
    }

    public static void recur(int count, String[] charArray, char compare) throws IOException {
        if(count == l){
            String out = "";
            int ja = 0, mo = 0;
            for(String s : result) {
                if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) mo++;
                else ja++;
                out += s;
            }
            if(ja >= 2 && mo >= 1) bw.write(out + "\n");
        } else{
            String before = "A";
            for(int i=0; i<c; i++) {
                if(!isVisited[i] && /*!before.equals(charArray[i]) &&*/ compare < charArray[i].charAt(0)){
                    isVisited[i] = true;
                    before = charArray[i];
                    result[count] = charArray[i];

                    recur(count+1, charArray, charArray[i].charAt(0));
                    isVisited[i] = false;
                }
            }
        }
    }
}