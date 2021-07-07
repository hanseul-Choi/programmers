class Solution {
    fun solution(s: String): Boolean {
        var answer = true
        
        if(s.length != 4 && s.length != 6) answer = false 
        else {
            for(i in s.indices) {                
                
                // 0부터 9사이 확인 0.04ms
                if(s[i] < '0' || s[i] > '9') {
                    answer = false
                    break
                }
                
                // isDigit 함수 이용 0.1ms
                // if(!s[i].isDigit()) {
                //     answer = false
                //     break
                // }
            }
            
            //toIntOrNull() 메소드 이용 11.66ms
            // if(s.toIntOrNull() == null) answer = false
        }
        
        return answer
    }
}