class Solution {
    fun solution(n: Int): Int {
        var answer = 0
     
        var n_str = n.toString()
        
        for(i in n_str.indices) {
            //toInt()로 변환시 아스키코드 값이 나옴
            answer += n_str[i] - '0'
        }

        return answer
    }
}