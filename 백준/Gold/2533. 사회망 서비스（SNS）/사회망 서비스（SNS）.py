from sys import stdin, setrecursionlimit
input = stdin.readline
setrecursionlimit(10 ** 7)

def dfs(node):
    for child in graph[node]:
        if not visited[child]:
            visited[child] = True
            dfs(child)
            dp[node][0] += dp[child][1]
            dp[node][1] += min(dp[child])

if __name__ == "__main__":
    n = int(input())
    graph = [[] for _ in range(n+1)]
    for _ in range(n - 1):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    dp = [[0, 1] for _ in range(n+1)]
    visited = [False for _ in range(n+1)]
    visited[1] = True
    dfs(1)
    print(min(dp[1]))