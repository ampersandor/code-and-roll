from collections import defaultdict
from heapq import heappush, heappop

n, m, x = map(int, input().split())

edges = defaultdict(dict)

INF = float('inf')

for _ in range(m):
    a, b, c = map(int, input().split())
    edges[a][b] = min(edges[a].get(b, 100), c)


def dijkstra(start):
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

dist = dijkstra(x)
for i in range(1, n+1):
    dist[i] += dijkstra(i)[x]

print(max(dist[1:]))

