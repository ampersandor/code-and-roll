from collections import defaultdict
from heapq import heappush, heappop


v, e = map(int, input().split())
INF = float('inf')
k = int(input())

edges = defaultdict(dict)
for _ in range(e):
    a, b, c = map(int, input().split())
    edges[a][b] = min(edges[a].get(b, INF), c)

dist = [INF] * (v + 1)
dist[k] = 0
heap = [(0, k)]

while heap:
    cost, node = heappop(heap)
    for child, nc in edges[node].items():
        n_cost = cost + nc
        if n_cost < dist[child]:
            dist[child] = n_cost
            heappush(heap, (n_cost, child))

for i in range(1, v + 1):
    print(dist[i] if dist[i] < INF else "INF")
