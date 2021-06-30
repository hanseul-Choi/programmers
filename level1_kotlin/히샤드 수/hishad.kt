class Solution {
    fun solution(x: Int): Boolean {
        var answer = true
        
        var s = x.toString()
        var tmp : Int = 0
        
        //문자열의 문자에 접근하기 위해서는 배열처럼 생각
        for(i in s.indices) {
            tmp += s[i] - '0'
        }
        
        //kotlin은 삼항 연산자가 없음
        if(x % tmp != 0) answer = false
                    
        return answer 
    }
}