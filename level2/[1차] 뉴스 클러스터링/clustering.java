import java.util.*;

class Solution {
    public int solution(String str1, String str2) {   
        //문자열 가공        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase(); 
        
        ArrayList<String> set1 = new ArrayList<>();
        set1 = makeSet(str1);
        ArrayList<String> set2 = new ArrayList<>();
        set2 = makeSet(str2);
        
        int[] hap_gyo = hap_gyo_set(set1, set2); // 겹치는 부분 계산        
        int hap = hap_gyo[0];
        int gyo = hap_gyo[1];
        
        if(gyo == 0 && hap == 0) return 65536;
        
        double JACARD = (double)gyo / (double)hap;      
        int score = (int)(JACARD * 65536);
        
        return score;
    }  
    
    public ArrayList<String> makeSet(String str) {
        int str_len = str.length();
        char[] str_set = str.toCharArray();
        ArrayList<String> al = new ArrayList<>();
        
        for(int i=0; i<str_len-1; i++) {
            if(isEnglish(str_set[i]) && isEnglish(str_set[i+1])) {                
                al.add(String.valueOf(str_set[i]) + String.valueOf(str_set[i+1]));
            }
        } 
        
        return al;
    }
    
    public boolean isEnglish(char c) {
        if(c <= 122 && c >= 97) return true;
        
        return false;
    }
    
    public int[] hap_gyo_set(ArrayList<String> al1, ArrayList<String> al2) {        
        int cnt_gyo = 0;
        int al1_size = al1.size();     
        
        for(int i=0; i<al1_size; i++) {
            for(int j=0; j<al2.size(); j++) {
                if(al1.get(i).equals(al2.get(j))) {
                    al2.remove(j);
                    cnt_gyo++;
                    break;
                }
            }
        }
        
        int cnt_hap = al1_size + al2.size();
        int[] cnt_hap_gyo = {cnt_hap, cnt_gyo};       
        
        return cnt_hap_gyo;
    }
}