class Solution {
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.visited = new boolean[n];
        
        for (int computer = 0; computer < n; computer++) {
            if (!visited[computer]) {
                dfs(computer, computers);    
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int node, int[][] computers) {
        for (int i = 0; i < computers.length; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, computers);
            }
        }
    }
    
    
}