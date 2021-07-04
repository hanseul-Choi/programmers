class Solution {
    fun solution(n: Long): IntArray {
        var num: String = n.toString()
        var al = ArrayList<Int>()        
        
        for(i in num.length-1 downTo 0) {
            al.add(num[i] - '0')
        }                
                                
        return al.toIntArray()
    }
}