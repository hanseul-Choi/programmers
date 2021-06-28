import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        if(a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }     
        
        a+=n - 1;
        b+=n - 1;        
       
        while(true) {
            a /= 2;
            b /= 2;            
           
            answer++;
            
            if(a==b) break;
        } 
        
        return answer;
    }
}