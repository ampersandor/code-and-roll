from math import log2
from sys import stdin
from collections import defaultdict, deque

input = stdin.readline
n = int(input())
log = int(log2(n) + 1)
graph = defaultdict(list)
parent = [[0] * (n+1) for _ in range(log)]
depth = [0] * (n + 1)
costs = [0] * (n + 1)
weight = defaultdict(dict)


for _ in range(n-1):
    a, b, c = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    weight[a][b] = c
    weight[b][a] = c

que = deque([(1, 0, 0)]) # node, cost, depth
visited = [False] * (n+1)
visited[1] = True
while que:
    node, c, d = que.popleft()
    depth[node] = d
    costs[node] = c
    for child in graph[node]:
        if not visited[child]:
            que.append((child, c + weight[node][child], d + 1))
            visited[child] = True
            parent[0][child] = node


for l in range(1, log):
    for i in range(1, n+1):
        parent[l][i] = parent[l-1][parent[l-1][i]]

del visited
del graph

def lca(x, y):
    if depth[x] > depth[y]:
        x, y = y, x

    for i in range(log-1, -1, -1):
        if depth[y] - depth[x] >= 2 ** i:
            y = parent[i][y]

    if x == y:
        return x

    for i in range(log-1, -1, -1):
        if parent[i][x] != parent[i][y]:
            x = parent[i][x]
            y = parent[i][y]

    return parent[0][x]

def find(x, i):
    for l in range(log-1, -1, -1):
        if (i-1) & (1 << l):
            x = parent[l][x]

    return x


m = int(input())
for _ in range(m):
    op, *args = map(int, input().split())
    if op == 1:
        u, v = args
        node = lca(u, v)
        print(costs[u] + costs[v] - 2 * costs[node])
    else:
        u, v, k = args
        node = lca(u, v)
        length = depth[u] + depth[v] - depth[node] * 2

        if depth[u] - depth[node] + 1 == k:
            print(node)
        elif depth[u] - depth[node] + 1 > k:
            print(find(u, k))
        else:
            print(find(v, length-k+2))