// class Solution {
//     fun solution(s: String, n: Int): String {
//         var answer = ""
        
//         var arr = s.toCharArray()
        
//         for(i in arr.indices) {
//             var tmp = arr[i].toInt()
            
//             //소문자와 대문자의 아스키코드 값 차이가 7이기 때문에 122 이상, 90이상으로 넘어가는 값을 체크하기는 어려울듯... 
//             if(tmp >= 65 && tmp <= 90) { //소문자인 경우                
//                  if(tmp + n > 90) {
//                     answer += (tmp + n - 26).toChar()
//                  } else {
//                     answer += (tmp + n).toChar() 
//                  }            
//             } else if(tmp >= 97 && tmp <= 122) { // 대문자인 경우
//                 if(tmp + n > 122) {
//                     answer += (tmp + n - 26).toChar()
//                 } else {
//                     answer += (tmp + n).toChar()
//                 }
//             } else { //공백인 경우
//                 answer += arr[i]
//             }
//         }
        
//         return answer
//     }
// }

class Solution {
    fun solution(s: String, n: Int): String {
        var tmp = s.toList().joinToString(separator = "") {
            when(it) {
                in 'A'..'Z' -> ('A'.toInt() + ((it.toInt() - 'A'.toInt() + n) % ('Z' - 'A' + 1))).toChar()  
                in 'a'..'z' -> ('a'.toInt() + ((it.toInt() - 'a'.toInt() + n) % ('z' - 'a' + 1))).toChar()
                else -> it
            }.toString()
        }
        
        return tmp
    }
}