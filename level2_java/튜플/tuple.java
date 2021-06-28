import java.util.*;

class Solution {
    public int[] solution(String s) {        
        
        s = s.substring(2,s.length()-2).replace("},{", "-");
        String[] str = s.split("-");
        
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });                
        
        ArrayList<Integer> al = new ArrayList<>();
        
        int str_len = str.length;
        for(int i=0; i<str_len; i++) {
            String[] str2 = str[i].split(",");
            
            int str2_len = str2.length;
            for(int j=0; j<str2_len; j++) {
                int val = Integer.parseInt(str2[j]);
                if(!al.contains(val)) al.add(val);                
            }
        }
        
        int al_size = al.size();
        int[] answer = new int[al_size];
        
        for(int i=0; i<al_size; i++) {
            answer[i] = al.get(i);
        }
                                
        return answer;
    }
}