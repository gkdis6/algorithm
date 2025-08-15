import java.util.*;

class Solution {
    private Set<String> structures;
    
    public int[][] solution(int n, int[][] build_frame) {
        structures = new HashSet<>();
        
        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1]; 
            int a = frame[2];
            int b = frame[3];
            
            String key = x + "," + y + "," + a;
            
            if (b == 1) {
                structures.add(key);
                if (!isValidStructure(n)) {
                    structures.remove(key);
                }
            } else {
                structures.remove(key);
                if (!isValidStructure(n)) {
                    structures.add(key);
                }
            }
        }
        
        List<int[]> result = new ArrayList<>();
        for (String structure : structures) {
            String[] parts = structure.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            int a = Integer.parseInt(parts[2]);
            result.add(new int[]{x, y, a});
        }
        
        result.sort((a1, a2) -> {
            if (a1[0] != a2[0]) return a1[0] - a2[0];
            if (a1[1] != a2[1]) return a1[1] - a2[1];
            return a1[2] - a2[2];
        });
        
        return result.toArray(new int[result.size()][]);
    }
    
    private boolean isValidStructure(int n) {
        for (String structure : structures) {
            String[] parts = structure.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            int a = Integer.parseInt(parts[2]);
            
            if (a == 0) {
                if (!canInstallColumn(x, y, n)) {
                    return false;
                }
            } else {
                if (!canInstallBeam(x, y, n)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean canInstallColumn(int x, int y, int n) {
        if (y == 0) return true;
        
        if (hasBeam(x-1, y) || hasBeam(x, y)) return true;
        
        if (hasColumn(x, y-1)) return true;
        
        return false;
    }
    
    private boolean canInstallBeam(int x, int y, int n) {
        if (hasColumn(x, y-1) || hasColumn(x+1, y-1)) return true;
        
        if (hasBeam(x-1, y) && hasBeam(x+1, y)) return true;
        
        return false;
    }
    
    private boolean hasColumn(int x, int y) {
        return structures.contains(x + "," + y + ",0");
    }
    
    private boolean hasBeam(int x, int y) {
        return structures.contains(x + "," + y + ",1");
    }
}