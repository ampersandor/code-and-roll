from collections import defaultdict
from heapq import heappush, heappop

n = int(input())
m = int(input())
INF = 1e9

edges = defaultdict(dict)
for _ in range(m):
    a, b, c = map(int, input().split())
    edges[a][b] = min(c, edges[a].get(b, INF))

A, B = map(int, input().split())
visited = [INF] * (n+1)

def dijkstra():
    heap = [(0, A)]
    visited[A] = 0
    while heap:
        cost, node = heappop(heap)
        for child, ncost in edges[node].items():
            if cost + ncost < visited[child]:
                heappush(heap, (cost + ncost, child))
                visited[child] = cost + ncost

dijkstra()
print(visited[B])