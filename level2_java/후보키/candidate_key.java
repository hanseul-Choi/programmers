import java.util.*;

class Solution {
    public int col, row;
    public boolean[] check;  
    public ArrayList<String> keySet = new ArrayList<>();
    
	public int solution(String[][] relation) {
		col = relation[0].length;
        row = relation.length;
        
        check = new boolean[col];
        
        dfs(0, relation);
                        
        ArrayList<List<String>> answer = new ArrayList<>();
        
        Collections.sort(keySet, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });
        
        int keySet_size = keySet.size();
        
        for(int i=0; i<keySet_size; i++) {
            List<String> cKey = Arrays.asList(keySet.get(i).split(""));
                         
            boolean checker = true;
            
            int answer_size = answer.size();
            
            for(int j=0; j<answer_size; j++) {
                if(cKey.containsAll(answer.get(j))) {
                    checker = false;
                    break;
                }
            }
            
            if(checker) answer.add(cKey);
        }        
                        
        return answer.size();
    }	
    
    public void dfs(int cnt, String[][] relations) {
        if(cnt == col) {            
            String key = "";
            
            HashSet<String> hs = new HashSet<>();
            
            //유일성 체크 및 key 생성
            for(int i=0; i<row; i++) {
                String s = "";
                
                for(int j=0; j<col; j++) {
                    if(check[j]) {
                        if(i == 0) key += j; //colmn 키 생성
                        
                        s += relations[i][j] + " ";
                    }
                }
                
                //유일성 체크
                if(hs.contains(s)) return;
                else hs.add(s);
            }
            
            if(key.equals("")) return;
            
            keySet.add(key);
                        
            return;
        }
        
        check[cnt] = true;
        dfs(cnt+1, relations);
        
        check[cnt] = false;
        dfs(cnt+1, relations);
    }
}