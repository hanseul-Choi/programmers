class Solution {
    fun solution(n: Long): Long {
        var num = n.toString()
        var tmp = ArrayList<Char>()
                        
        for(i in num.indices) {
            tmp.add(num[i])            
        } 
        
        tmp.sort()        
        
        var answer: String = ""
        
        for(i in num.length-1 downTo 0) {
            answer += tmp[i]
        }
        
        return answer.toLong()
    }
}