import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        ArrayList<String> cache = new ArrayList<>();
        int cities_len = cities.length;
        
        if(cacheSize == 0) answer = cities_len * 5;
        else {
            int cur = 0;
            
            for(int i=0; i<cities_len; i++) {
                String city = cities[i].toLowerCase();                

                if(cache.contains(city)) {
                    answer++;                    
                    cache.remove(city);
                    cache.add(city);   
                } else {
                    answer += 5;
                    
                    if(cache.size() >= cacheSize) {
                        cache.remove(0);
                    }
                        
                    cache.add(city);
                }                      
            }            
        }
        
        return answer;
    }
}