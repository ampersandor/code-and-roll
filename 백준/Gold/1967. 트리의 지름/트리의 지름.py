from collections import defaultdict
from heapq import heappush, heappop

n = int(input())
edges = defaultdict(dict)
INF = float('inf')

for _ in range(n-1):
    a, b, c = map(int, input().split())
    edges[a][b] = min(edges[a].get(b, INF), c)
    edges[b][a] = min(edges[b].get(a, INF), c)

def dijkstra(start):
    heap = [(0, start)]
    dist = [INF] * (n + 1)
    dist[start] = 0
    max_len = 0
    max_node = -1

    while heap:
        cost, node = heappop(heap)
        if max_len < cost:
            max_len = cost
            max_node = node

        for child, nc in edges[node].items():
            n_cost = cost + nc
            if n_cost < dist[child]:
                dist[child] = n_cost
                heappush(heap, (n_cost, child))

    return max_len, max_node

_, start = dijkstra(1)
res, _ = dijkstra(start)

print(res)
