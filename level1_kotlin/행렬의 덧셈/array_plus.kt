class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        // var answer = arrayOf<IntArray>()
        
        for(i in arr1.indices) {            
            for(j in arr1.get(0).indices) {
                arr1[i][j] += arr2[i][j]
            }
        }
        
        return arr1
    }
}