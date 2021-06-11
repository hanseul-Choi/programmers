import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int skill_trees_len = skill_trees.length;
        char[] skill_arr = skill.toCharArray();
        
        for(int i=0; i<skill_trees_len; i++) {            
            String skill_tree = skill_trees[i];
            
            boolean check = true;
            
            for(int j=0; j<skill_arr.length; j++) {
                int skill_pos = skill_tree.indexOf(skill_arr[j]);
                
                if(skill_pos == -1) {
                    for(int k=j+1; k<skill_arr.length; k++) {
                        if(skill_tree.contains(Character.toString(skill_arr[k]))) {
                            check = false;
                            break;
                        }
                    }
                    
                    break;
                }
                
                String part_skill = skill_tree.substring(0, skill_pos);           
                for(int k=j+1; k<skill_arr.length; k++) {
                    if(part_skill.contains(Character.toString(skill_arr[k]))) {
                        check = false;
                        break;
                    }
                }
                
                if(!check) break;
            }
            
            if(check) answer++;            
        }
        return answer;
    }
}