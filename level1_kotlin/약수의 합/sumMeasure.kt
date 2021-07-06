// class Solution {
//     fun solution(n: Int): Int {
//         var answer = 0
        
//         for(i in 1..n) { //3000번 이하라 for문 가능할듯.. 더 빨리하는 방법이 있을까?
//             if(n % i == 0) answer += i
//         } 
        
//         return answer
//     }
// }

class Solution {
    fun solution(n: Int): Int {
        var answer = n
        
        for(i in 1..n/2) {
            if(n % i == 0) answer += i
        }
        
        return answer
    }    
}