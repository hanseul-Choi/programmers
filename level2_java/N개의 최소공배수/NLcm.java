class Solution {
    public int solution(int[] arr) {
                
        int arr_len = arr.length;
        
        for(int i=1; i<arr_len; i++) {
            arr[i] = lcm(arr[i-1], arr[i]);
        }
        
        return arr[arr_len-1];
    }
    
    public int gcd(int a, int b) {
        while(b > 0) {
            int r = a;
            a = b;
            b = r%b;
        }
        
        return a;
    }
    
    public int lcm(int a, int b) {
        return a * b / gcd(a,b);
    }
}