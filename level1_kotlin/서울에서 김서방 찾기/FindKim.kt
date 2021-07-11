class Solution {
    fun solution(seoul: Array<String>): String {
        var answer = ""
        
        for(i in 0..seoul.size-1) {
            if(seoul[i] == "Kim") {
                answer = "김서방은 " + i + "에 있다"
                break
            }
        }
        
        return answer
    }
}