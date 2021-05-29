import java.util.*;

class Solution {
    public long answer = 0;    
    public boolean[] visit = new boolean[3];
    public char[] list = new char[3];
    public char[] oper_set = {'+', '-', '*'};    
    
    public ArrayList<Long> num_list = new ArrayList<>();
    public ArrayList<Character> oper_list = new ArrayList<>();
    
    public long solution(String expression) { 
        
        char[] exp = expression.toCharArray();
        int exp_len = exp.length;
        StringBuilder sb = new StringBuilder();
        
        //num과 oper 분리
        for(int i=0; i<exp_len; i++) {            
            if(exp[i] == '+' || exp[i] == '-' || exp[i] == '*') {
                oper_list.add(exp[i]);              
                num_list.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
            } else {                
                sb.append(exp[i]);
            }
        }
        num_list.add(Long.parseLong(sb.toString()));
        
        comb(0);
        
        return answer;
    }    
    
    public void comb(int cnt) {
        if(cnt == 3) {
            calculate();
            
            return;    
        }
        
        for(int i=0; i<3; i++) {
            
            if(visit[i]) continue;
            visit[i] = true;
            list[cnt] = oper_set[i];
            
            comb(cnt+1);
            visit[i] = false;
        }        
    }
    
    public void calculate() {
        ArrayList<Long> num = new ArrayList<>();
        num.addAll(num_list);
        
        ArrayList<Character> op = new ArrayList<>();
        op.addAll(oper_list);
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<op.size(); j++) {
                
                if(op.get(j) == list[i]) {
                    Long n1 = num.get(j);
                    Long n2 = num.get(j+1);
                    Long res = cal(n1,n2,list[i]);
                    
                    num.remove(j+1);
                    num.remove(j);
                    
                    op.remove(j);
                    
                    num.add(j, res);
                    j--;
                }
            }
        }
        
        answer = Math.max(Math.abs(num.get(0)),answer);
    }
    
    public Long cal(Long l1, Long l2, char op) {
        
        long res = 0;
        
        switch(op) {
            case '*':
                res = l1 * l2;
                break;
            case '+':
                res = l1 + l2;
                break;
            case '-':
                res = l1 - l2;
                break;
        }
        
        return res;        
    }
}