import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] strArray = new String[n];

        for(int i=0; i<n; i++){
            strArray[i] = br.readLine();
        } // 문자열 배열 완성

        ArrayList<Character> duplication = new ArrayList<>();

        for(int i=0; i<n; i++) {
            String str = strArray[i];
            char current = str.charAt(0);   // 첫번째 문자
            // 한 문자열씩 순회
            for(int j=1; j<str.length(); j++){
                char c = str.charAt(j);
                if(c != current){
                    duplication.add(current);
                    if(duplication.contains(c)){
                        strArray[i] = "";   // 문자열 불필요하여 삭제
                        break;
                    }else{
                        current = c;
                    }
                }
            }
            duplication.clear();
        }

        int result = 0;
        for(int i=0; i<n; i++){
            if(strArray[i] != ""){
                result++;
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}