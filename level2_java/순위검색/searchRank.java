import java.util.*;

class Solution {
    public HashMap<String, ArrayList<Integer>> dev = new HashMap<>();
        
    public int[] solution(String[] info, String[] query) {                
        int info_len = info.length;
        
        for(int i=0; i<info_len; i++) {
            String[] s = info[i].split(" ");
            String[] lan = {s[0], "-"};
            String[] job = {s[1], "-"};
            String[] career = {s[2], "-"};
            String[] food = {s[3], "-"}; 
         
            Integer score = Integer.parseInt(s[4]);
            
            for(int j=0; j<2; j++) {
                for(int k=0; k<2; k++) {
                    for(int p=0; p<2; p++) {
                        for(int l=0; l<2; l++){                            
                            String key = lan[j] + job[k] + career[p] + food[l];                                   

                            if(dev.containsKey(key)) {
                                ArrayList<Integer> arr = dev.get(key);
                                arr.add(score);
                                dev.put(key, arr);
                            } else {
                                ArrayList<Integer> arr = new ArrayList<>();
                                arr.add(score);
                                dev.put(key, arr);
                            }
                            
                        }
                    }
                }
            }            
        }
        
        //정렬
        for(String key : dev.keySet()) {
            ArrayList<Integer> arr = dev.get(key);
            Collections.sort(arr);
            dev.put(key, arr);
        }
        
        //쿼리문 처리
        int query_len = query.length;
        int[] answer = new int[query_len];
        
        for(int i=0; i<query_len; i++) {
            String[] s = query[i].split(" ");
            String key = s[0] + s[2] + s[4] + s[6];
            Integer score = Integer.parseInt(s[7]);
            
            if(!dev.containsKey(key)) {
                answer[i] = 0;
                continue;
            }
                
            answer[i] = BinarySearch(dev.get(key), score);
        }
        
        return answer;
    }
    
    public int BinarySearch(ArrayList<Integer> arr, int score) {
        int arr_size = arr.size();
        
        int start = 0;
        int end = arr_size;
        int mid = 0;
        
        while(end > start) {
            mid = (start + end)/2;
            
            if(arr.get(mid) >= score) {
                end = mid;
            } else start = mid + 1;
        }
        
        return arr_size - start;
    }
    
}