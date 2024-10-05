// 2:33 -> 3:16
import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> map = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            int index = i;
            
            if(map.containsKey(genre)){
                Genre g = map.get(genre);
                g.addSong(new Song(index, play));
                g.plus(play);
                
            }else{
                List<Song> list = new ArrayList<>();
                list.add(new Song(index, play));
                
                Genre g = new Genre(list, play);
                map.put(genre, g);
            }
        }
        
        List<Map.Entry<String, Genre>> sortList = new ArrayList<>(map.entrySet());
        Collections.sort(sortList, new Comparator<Map.Entry<String, Genre>>(){
            public int compare(Map.Entry<String, Genre> a, Map.Entry<String, Genre> b){
                return b.getValue().sum - a.getValue().sum;
            }
        });
        
        for(Map.Entry<String, Genre> m : sortList){
            List<Song> list = m.getValue().list;
            Collections.sort(list, new Comparator<Song>(){
                public int compare(Song a, Song b){
                    if(b.play == a.play){
                        return a.index - b.index;
                    }
                    return b.play - a.play;
                }
            });
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(Map.Entry<String, Genre> m : sortList){
           // System.out.print(m.getKey() + " " + m.getValue().sum + ", / ");
             List<Song> l = m.getValue().list;
            if(l.size() < 2)    result.add(l.get(0).index);
            else{
                for(int i=0; i<2; i++){
                    result.add(l.get(i).index);
                }
            }
            for(Song s : l){
               // System.out.print(s.index + ", " + s.play + " / ");
            }
           // System.out.println();
        }
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    class Genre {
        private List<Song> list;
        private int sum;
        
        public Genre(List<Song> list, int sum){
            this.list = list;
            this.sum = sum;
        }
        public void plus(int add){
            sum += add;
        }
        public void addSong(Song s){
            list.add(s);
        }
    }
    
    class Song {
        private int index; private int play;
        public Song(int index, int play){
            this.index = index;
            this.play = play;
        }
    }

}
// 장르별로 1,2위를 골라 출시 
// 장르 기준 -> 재생 기준 -> 번호 낮은 기준