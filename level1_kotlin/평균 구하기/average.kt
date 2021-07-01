class Solution {
    fun solution(arr: IntArray): Double {
        var answer: Double = 0.0
        
        for(i in arr.indices) answer += arr[i]
        
        return answer / arr.size
    }
}