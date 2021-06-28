class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer = LongArray(n)        
        var tmp: Long = x.toLong()
        
        for(i in 0..n-1) {
            answer.set(i, tmp)
            tmp += x.toLong()            
        }
        
        return answer
    }
}