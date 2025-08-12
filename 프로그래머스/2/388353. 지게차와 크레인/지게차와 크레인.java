class Solution {
    final int[] DX = {-1, 1, 0, 0};
    final int[] DY = {0, 0 ,-1, 1};
    int n,m, answer;
    char[][] map;
    boolean[][] visited;
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        answer = n * m;
        map = new char[n][m];
        for(int i = 0; i < n; i++) {
            map[i] = storage[i].toCharArray();
        }
        
        for(String request : requests) {
            if(request.length() == 1) {
                useCar(request.charAt(0));
            } else {
                useCrane(request.charAt(0));
            }
        }
        return answer;
    }
    
    public void useCrane(char request) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == request) {
                    answer--;
                    map[i][j] = 0;
                }
            }
        }
    }
    
        
    public void useCar(char request) {
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            if(!visited[i][0]) dfs(i, 0, request);
            if(!visited[i][m-1]) dfs(i, m-1, request);
        }
        for(int i = 0; i < m; i++) {
            if(!visited[0][i]) dfs(0, i, request);
            if(!visited[n-1][i]) dfs(n-1, i, request);
        }
    }
    
    public void dfs(int x, int y, char request) {
        visited[x][y] = true;
        if(map[x][y] == 0) {
            for(int i = 0; i < DX.length; i++) {
                int lx = x + DX[i];
                int ly = y + DY[i];
                if(lx < 0 || ly < 0 || lx >= n || ly >= m) continue;
                if(!visited[lx][ly]) dfs(lx, ly, request);
            }
        }
        if(map[x][y] == request) {
            answer--;
            map[x][y] = 0;
        }
    }
}