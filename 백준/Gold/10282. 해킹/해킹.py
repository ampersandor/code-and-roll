from sys import stdin
from collections import defaultdict
from heapq import heappush, heappop
input = stdin.readline
tests = int(input())
INF = float('inf')

def dijkstra(n, graph, start):
    dist = [INF] * (n+1)
    heap = [(0, start)]
    dist[start] = 0
    while heap:
        cost, node = heappop(heap)
        for child, nc in graph[node].items():
            ncost = cost + nc
            if ncost < dist[child]:
                dist[child] = ncost
                heappush(heap, (ncost, child))
    return dist

for _ in range(tests):
    graph = defaultdict(dict)

    n, d, c = map(int, input().split())
    for _ in range(d):
        a, b, s = map(int, input().split())
        graph[b][a] = s

    dist = dijkstra(n, graph, c)
    res, count = 0, 0
    for d in dist:
        if d != INF:
            count += 1
            res = max(res, d)
    print(count, res)