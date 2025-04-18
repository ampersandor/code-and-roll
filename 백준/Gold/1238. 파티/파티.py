from collections import defaultdict
from heapq import heappush, heappop

n, m, x = map(int, input().split())

edges = defaultdict(dict)
rev_edges = defaultdict(dict)
INF = float('inf')

for _ in range(m):
    a, b, c = map(int, input().split())
    edges[a][b] = min(edges[a].get(b, 100), c)
    rev_edges[b][a] = min(rev_edges[b].get(a, 100), c)

def dijkstra(start, edges):
    heap = [(0, start)]
    dist = [INF] * (n + 1)
    dist[start] = 0
    while heap:
        cost, node = heappop(heap)
        for child, nc in edges[node].items():
            n_cost = cost + nc
            if n_cost < dist[child]:
                heappush(heap, (n_cost, child))
                dist[child] = n_cost

    return dist

dist1 = dijkstra(x, edges)
dist2 = dijkstra(x, rev_edges)

res = 0
for i in range(1, n+1):
    if i != x:
        res = max(res, dist1[i] + dist2[i])

print(res)
