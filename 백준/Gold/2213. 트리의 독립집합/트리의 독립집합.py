from collections import defaultdict

n = int(input())
weights = list(map(int, input().split()))
graph = defaultdict(list)

for _ in range(n-1):
    a, b = map(lambda x: int(x) - 1, input().split())
    graph[a].append(b)
    graph[b].append(a)

dp = [[0, weights[i]] for i in range(n)]

def dfs(node, parent):
    for child in graph[node]:
        if parent != child:
            dp[node][0] += dfs(child, node)
            dp[node][1] += dp[child][0]

    return max(dp[node])

res = dfs(0, 0)

children = []
def dfs2(node, parent, took):
    if took or dp[node][0] > dp[node][1]:
        for child in graph[node]:
            if child != parent:
                dfs2(child, node, False)
    else:
        if dp[node][0] <= dp[node][1]:
            children.append(node + 1)
        for child in graph[node]:
            if child != parent:
                dfs2(child, node, True)

dfs2(0, 0, False)

print(res)
print(*sorted(children))
