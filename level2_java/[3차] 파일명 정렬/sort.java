import java.util.*;

class Solution {
    public String[] solution(String[] files) {        
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                String[] a_split = splitString(a);
                String[] b_split = splitString(b);
                
                int head_check = a_split[0].compareTo(b_split[0]);
                
                if(head_check == 0) {
                    int a_check = Integer.parseInt(a_split[1]);
                    int b_check = Integer.parseInt(b_split[1]);
                    
                    return a_check - b_check;                    
                } else return head_check;                                
            }
        });    
                
        return files;
    }
    
    public String[] splitString(String s) {
        String[] split = new String[2];
        
        s = s.toUpperCase(); //tail도 바뀌는 예외사항이 발생할 수 있음.
        
        String head = "";
        int idx = 0;
        
        //head
        for(;idx<s.length(); idx++){
            char c = s.charAt(idx);
            if(c < 48 || c > 57) {
                head += c;
            } else break;
        }
        
        String number = "";
        for(; idx<s.length(); idx++) {
            char c = s.charAt(idx);
            if(c >= 48 && c <= 57) {
                number += c;
            } else break;
        }
        
        split[0] = head;
        split[1] = number;        
        
        return split;
    }
}