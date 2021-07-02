class Solution {
    fun solution(num: Int): Int {
        var answer = 0
        
        var tmp : Long = num.toLong()
        
        while(tmp != 1L) {
            if(tmp % 2 == 0L) tmp /= 2
            else tmp = (tmp * 3) + 1
            
            answer++
            
            if(answer == 500) {
                answer = -1
                break
            }
        }
        
        return answer
    }
}