class Solution {
    fun solution(s: String): String {
        var answer = ""
        
        var check = 0
        
        for(i in s.indices) {
            var tmp = s[i]
            
            if(tmp == ' ') {
                check = 0
                answer+=' '
            } else {
                if(check % 2 == 0) {
                    answer += tmp.toUpperCase()
                    check++
                } else {
                    answer += tmp.toLowerCase()
                    check++
                } 
            } 
        }
               
        return answer
    }
}