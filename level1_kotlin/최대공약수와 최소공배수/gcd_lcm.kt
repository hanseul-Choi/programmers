class Solution {
    fun solution(n: Int, m: Int): IntArray {
        var answer = IntArray(2)
        
        var gcd = if(n < m) gcd(n, m) else gcd(m, n)
       
        answer[0] = gcd
        answer[1] = lcm(n, m, gcd)
        
        return answer
    }
    
    fun gcd(a: Int, b: Int): Int {
        if(a % b == 0) return b
        
        return gcd(b, a%b)
    }
    
    fun lcm(a: Int, b: Int, c: Int) : Int {
        return a * b / c
    } 
}