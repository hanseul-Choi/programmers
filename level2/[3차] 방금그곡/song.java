import java.util.*;

class Solution { 
    public ArrayList<Music> music_list = new ArrayList<>();
    public String[] base_melody = {"C#", "D#", "F#", "G#", "A#"};
    public String[] change_melody = {"c", "d", "f", "g", "a"};
    
    public class Music {
        String name;
        int time;
        
        Music(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        int musicinfos_len = musicinfos.length;
        
        for(int i=0; i<5; i++) { //#의 형태 변환 ex) A# -> a
            m = m.replace(base_melody[i], change_melody[i]);    
            
            for(int j=0; j<musicinfos_len; j++) {
                musicinfos[j] = musicinfos[j].replace(base_melody[i], change_melody[i]);
            }
        }
        
        for(int i=0; i<musicinfos_len; i++) {
            checkMusic(musicinfos[i], m);
        }
        
        Collections.sort(music_list, new Comparator<Music>(){
           @Override
            public int compare(Music a, Music b) {
                return b.time - a.time;
            }
        }); 
        
        if(music_list.size() == 0) return "(None)";
        
        return music_list.get(0).name;
    }  
    
    public void checkMusic(String musicinfo, String melody) {
        String[] music = musicinfo.split(",");
        String[] start_time = music[0].split(":");
        String[] end_time = music[1].split(":");
        
        int hour = Integer.parseInt(end_time[0]) - Integer.parseInt(start_time[0]); //시간 분리
        int min = Integer.parseInt(end_time[1]) - Integer.parseInt(start_time[1]);
        
        int time = hour * 60 + min; //시간 계산
        
        StringBuilder whole_melody = new StringBuilder(); //라디오에서 들린 전체 멜로디
        
        char[] melody_set = music[3].toCharArray();
        int melody_len = melody_set.length;
        int idx = 0;
        
        for(int i=0; i<time; i++) {
            whole_melody.append(melody_set[idx]);
            idx++;
            if(idx == melody_len) idx = 0;
        } 
                
        if(whole_melody.toString().contains(melody)) {
            music_list.add(new Music(music[2], time));
        }
    }
}