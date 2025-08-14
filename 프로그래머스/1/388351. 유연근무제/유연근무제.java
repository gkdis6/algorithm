class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        boolean[] arr = new boolean[schedules.length];
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] = true;
        }
        
        for(int i = 0; i < schedules.length; i++){
            for(int j = 0; j < timelogs[i].length; j++){
                int day = (j + startday - 1) % 7;
                if(day == 5 || day == 6) continue;
                
                if(!arr[i]) continue;
                
                int scheduleMinutes = (schedules[i] / 100) * 60 + (schedules[i] % 100);
                int arrivalMinutes = (timelogs[i][j] / 100) * 60 + (timelogs[i][j] % 100);
                
                if(arrivalMinutes > scheduleMinutes + 10) {
                    arr[i] = false;
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]) answer++;
        }
        
        return answer;
    }
}