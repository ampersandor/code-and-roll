from sys import stdin
from heapq import heappush, heappop
from collections import defaultdict
input = stdin.readline


v, e = map(int, input().split())
INF = float('inf')
graph = defaultdict(dict)


for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a][b] = min(graph[a].get(b, INF), c)
    graph[b][a] = min(graph[b].get(a, INF), c)

visited = [False] * (v + 1)

heap = [(0, 1)] # cost, node
count = 0
total_cost = 0

while count < v:
    cost, node = heappop(heap)
    if visited[node]:
        continue
    visited[node] = True
    total_cost += cost
    count += 1
    for child, nc in graph[node].items():
        if not visited[child]:
            heappush(heap, (nc, child))

print(total_cost)