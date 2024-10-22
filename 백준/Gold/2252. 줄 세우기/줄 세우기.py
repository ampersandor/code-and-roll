from collections import defaultdict, deque
from sys import stdin


input = stdin.readline

n, m = map(int, input().split())

graph = defaultdict(list)
indegree = [0] * n

for _ in range(m):
    a, b = map(lambda x: int(x) - 1, input().split())
    graph[a].append(b)
    indegree[b] += 1

que = deque()
for idx, degree in enumerate(indegree):
    if not degree:
        que.append(idx)

res = []

while que:
    node = que.popleft()
    res.append(node + 1)
    for child in graph[node]:
        indegree[child] -= 1
        if not indegree[child]:
            que.append(child)

print(*res)
