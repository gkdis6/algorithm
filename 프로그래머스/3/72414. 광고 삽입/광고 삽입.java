import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTimeInSec = timeToSeconds(play_time);
        int advTimeInSec = timeToSeconds(adv_time);
        
        long[] viewers = new long[playTimeInSec + 1];
        
        for (String log : logs) {
            String[] times = log.split("-");
            int start = timeToSeconds(times[0]);
            int end = timeToSeconds(times[1]);
            
            viewers[start]++;
            viewers[end]--;
        }
        
        for (int i = 1; i <= playTimeInSec; i++) {
            viewers[i] += viewers[i - 1];
        }
        
        for (int i = 1; i <= playTimeInSec; i++) {
            viewers[i] += viewers[i - 1];
        }
        
        long maxSum = viewers[advTimeInSec - 1];
        int bestStart = 0;
        
        for (int start = 1; start <= playTimeInSec - advTimeInSec; start++) {
            long currentSum = viewers[start + advTimeInSec - 1] - viewers[start - 1];
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
                bestStart = start;
            }
        }
        
        return secondsToTime(bestStart);
    }
    
    private int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        
        return hours * 3600 + minutes * 60 + seconds;
    }
    
    private String secondsToTime(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}