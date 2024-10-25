from collections import defaultdict, deque
from heapq import heappush, heappop

n, m = map(int, input().split())

graph = defaultdict(list)

heap = []
in_degree = [0] * n

for _ in range(m):
    a, b = map(lambda x: int(x) - 1, input().split())
    graph[a].append(b)
    in_degree[b] += 1

for i in range(n):
    if in_degree[i] == 0:
        heappush(heap, i)

res = []

while heap:
    node = heappop(heap)
    res.append(node + 1)
    for child in graph[node]:
        in_degree[child] -= 1
        if in_degree[child] == 0:
            heappush(heap, child)


print(*res)