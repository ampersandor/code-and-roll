"""
7
1 6 13
6 3 9
3 5 7
4 1 3
2 4 20
4 7 2
3
1 6
1 4
2 6
"""
from math import log2
from sys import stdin
from collections import defaultdict, deque

input = stdin.readline

n = int(input())

graph = defaultdict(list)
cost = defaultdict(dict)

for _ in range(n-1):
    a, b, c = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    cost[a][b] = c
    cost[b][a] = c

def find_root():
    for node in graph.keys():
        if len(graph[node]) == 1:
            return node
    return None

k = int(log2(n) + 1)
root = find_root()
parent = [[0] * (n+1) for _ in range(k)]
dist = [0] * (n+1)

depth = [0] * (n+1)
visited = [False] * (n+1)

que = deque([(root, 0, 0)]) # node, cost, depth
visited[root] = True

while que:
    node, c, d = que.popleft()
    depth[node] = d
    dist[node] = c
    for child in graph[node]:
        if not visited[child]:
            que.append((child, c + cost[node][child], d + 1))
            parent[0][child] = node
            visited[child] = True

for l in range(1, k):
    for i in range(1, n+1):
        parent[l][i] = parent[l-1][parent[l-1][i]]


def lca(x, y):
    if depth[x] > depth[y]:
        x, y = y, x

    for i in range(k-1, -1, -1):
        if depth[y] - depth[x] >= 2 ** i:
            y = parent[i][y]
    if x == y:
        return x

    for i in range(k-1, -1, -1):
        if parent[i][x] != parent[i][y]:
            x = parent[i][x]
            y = parent[i][y]

    return parent[0][x]

m = int(input())
for _ in range(m):
    a, b = map(int, input().split())
    r = lca(a, b)
    print(dist[a] + dist[b] - 2 * dist[r])

