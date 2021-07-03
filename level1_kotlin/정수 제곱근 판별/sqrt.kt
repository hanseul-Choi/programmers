import kotlin.math.*

class Solution {
    fun solution(n: Long): Long {       
        
        var num = sqrt(n.toDouble()).toLong()
        
        if(num.toDouble().pow(2) == n.toDouble()) {
            return (num + 1L).toDouble().pow(2).toLong()
        } else return -1               
    }
}