class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        int lines_len = lines.length;
        
        int[] start = new int[lines_len];
        int[] end = new int[lines_len];
        
        //시간 변환 및 시작점과 끝점 저장
        for(int i=0; i<lines_len; i++) {
            String[] split_line = lines[i].split(" ");
            
            int time = Integer.parseInt(split_line[1].substring(0,2)) * 60 * 60 * 1000;
            time += Integer.parseInt(split_line[1].substring(3,5)) * 60 * 1000;
            time += Integer.parseInt(split_line[1].substring(6,8)) * 1000;
            time += Integer.parseInt(split_line[1].substring(9,12));
            
            end[i] = time;
            
            int during_time = make_during_time(split_line[2].substring(0, split_line[2].indexOf("s")));
            
            start[i] = time - during_time + 1;
        }               
        
        //시작점과 끝점을 기준으로 1s window를 만든다. 이때, 시작점이 포함되어 있는지 확인하여 cnt를 센다.
        for(int i=0; i<lines_len; i++) {
                       
            //시작점 기준 윈도우 제작                      
            
            int tmp = check(start[i], start[i] + 999, start, end);            
            if(answer < tmp) answer = tmp;
            
            //끝점 기준 윈도우 제작            
            tmp = check(end[i], end[i] + 999, start, end);            
            if(answer < tmp) answer = tmp;
        }
        
        return answer;
    }
    
    public int make_during_time(String du) {       
        int sec = 0;
        
        if(du.contains(".")) sec = Integer.parseInt(du.substring(0, du.indexOf("."))) * 1000 + Integer.parseInt(du.substring(du.indexOf(".")+1, du.length()));
        else sec = Integer.parseInt(du) * 1000;        
                
        return sec;
    }
    
    public int check(int start, int end, int[] st, int[] ed) {
        int len = st.length;
        int log_cnt = 0; 
        
        for(int i=0; i<len; i++) {            
            if(st[i] >= start && st[i] <= end) log_cnt++; //시작점이 범위 안
            else if(ed[i] >= start && ed[i] <= end) log_cnt++; //끝점이 범위 안
            else if(st[i] <= start && ed[i] >= end) log_cnt++; //시작점과 끝점이 범위 바깥에 존재            
        }               
        
        return log_cnt;
    }   
}