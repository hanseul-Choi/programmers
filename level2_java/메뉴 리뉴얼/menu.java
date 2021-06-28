import java.util.*;

class Solution {
    public HashMap<String, Integer> hm = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        
        int orders_len = orders.length;
        int course_len = course.length;
        
        // String 정렬
        for(int i=0; i<orders_len; i++) {
            char[] arr = orders[i].toCharArray();
            
            Arrays.sort(arr);
            int arr_len = arr.length;
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<arr_len; j++) {
                sb.append(String.valueOf(arr[j]));
            }
            
            orders[i] = sb.toString();
        }
          
        // 순열
        for(int i=0; i<orders_len; i++) {
            char[] order = orders[i].toCharArray();            
            
            for(int j=0; j<course_len; j++) {
                boolean[] visit = new boolean[order.length];
                putSet(order, visit, course[j], 0, "", 0);
            }            
        }            
        
        // course에 따라 최댓값 뽑아내기
        ArrayList<String> al = new ArrayList<>();
        
        for(int i=0; i<course_len; i++) {
            int max = 0;
            
            for(String s : hm.keySet()) {
                if(s.length() == course[i]) {
                    if(max < hm.get(s)) max = hm.get(s);
                }
            }           
            
            if(max >= 2) {
                ArrayList<String> al2 = new ArrayList<>();
                
                for(String s : hm.keySet()) {
                    if(max == hm.get(s) && s.length() == course[i]) {                        
                        al2.add(s);
                    }
                }
                
                int al2_size = al2.size();
                
                for(int j=0; j<al2_size; j++) al.add(al2.get(j));
            }
        }        
        
        // 답을 사전 순서대로
        Collections.sort(al);
        
        int al_size = al.size();
        answer = new String[al_size];
        
        for(int i=0; i<al_size; i++) {
            answer[i] = al.get(i);
        }
        
        return answer;
    }
    
    public void putSet(char[] str, boolean[] visit, int goal_cnt, int cnt, String set, int start) {
        if(cnt == goal_cnt) {
            if(hm.containsKey(set)) {
                hm.put(set, hm.get(set) + 1);
            } else hm.put(set, 1);
            
            return;
        }
        
        int str_len = str.length;
        for(int i=start; i<str_len; i++) {
            if(visit[i]) continue;
            
            visit[i] = true;
            set += String.valueOf(str[i]);
            
            putSet(str, visit, goal_cnt, cnt+1, set, i);
            visit[i] = false;
            set = set.substring(0, set.length()-1);
        }
    }
}