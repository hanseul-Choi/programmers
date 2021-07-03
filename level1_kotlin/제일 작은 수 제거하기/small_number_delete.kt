class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer = ArrayList<Int>()
        
        var min: Int = arr[0]
        for(i in 1..arr.size-1) {
            if(min > arr[i]) min = arr[i]
        }
        
        for(i in 0..arr.size-1) {
            if(min != arr[i]) {
                answer.add(arr[i])
            }
        }
        
        if(answer.size == 0) answer.add(-1)    
            
        return answer.toIntArray()
    }
}