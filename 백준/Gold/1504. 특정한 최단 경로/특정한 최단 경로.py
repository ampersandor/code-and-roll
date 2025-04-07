from collections import defaultdict
from heapq import heappush, heappop
n, e = map(int, input().split())
INF = float('inf')

edges = defaultdict(dict)
for _ in range(e):
    a, b, c = map(int, input().split())
    edges[a][b] = min(edges[a].get(b, INF), c)
    edges[b][a] = min(edges[b].get(a, INF), c)


def dijkstra(start, end):
    heap = [(0, start)]
    dist = [INF] * (n+1)
    dist[start] = 0
    while heap:
        cost, node = heappop(heap)
        if node == end:
            return cost
        for child, nc in edges[node].items():
            n_cost = cost + nc
            if n_cost < dist[child]:
                heappush(heap, (n_cost, child))
                dist[child] = n_cost

    return INF


v1, v2 = map(int, input().split())

tmp = dijkstra(v1, v2)

res1 = dijkstra(1, v2) + tmp + dijkstra(v1, n)
res2 = dijkstra(1, v1) + tmp + dijkstra(v2, n)

res = min(res1, res2)
print(-1 if res == INF else res)
