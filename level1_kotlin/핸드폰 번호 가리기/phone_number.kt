class Solution {
    fun solution(phone_number: String): String {
        var answer = ""
        
        for(i in 0..phone_number.length-5) answer += "*"
                
        answer += phone_number.substring(phone_number.length-4, phone_number.length);
        
        return answer
    }
}