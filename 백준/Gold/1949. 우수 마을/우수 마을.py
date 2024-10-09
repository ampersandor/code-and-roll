from sys import stdin, setrecursionlimit
from collections import defaultdict
input = stdin.readline
setrecursionlimit(10**5)
n = int(input())
graph = defaultdict(list)
weights = list(map(int, input().split()))
dp = [[0, weights[i]] for i in range(n)]

for _ in range(n-1):
    a, b = map(lambda x: int(x) - 1, input().split())
    graph[a].append(b)
    graph[b].append(a)



def dfs(node, parent):
    for child in graph[node]:
        if parent != child:
            dfs(child, node)
            dp[node][0] += max(dp[child])
            dp[node][1] += dp[child][0]

dfs(0, 0)


print(max(dp[0]))

