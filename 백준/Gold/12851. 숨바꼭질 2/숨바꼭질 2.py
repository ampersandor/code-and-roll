import sys
from collections import deque

n, m = map(int, input().split())
que = deque([(n, 0)])
INF = float('inf')
min_cost = INF
ways = 0
dist = [INF] * 100001
while que:
    num, cost = que.popleft()
    if num == m:
        min_cost = cost
        ways += 1
        continue

    for i in [num + 1, num * 2, num - 1]:
        if 0 <= i < 100001 and cost <= dist[i]:
            que.append((i, cost + 1))
            dist[i] = cost
print(min_cost)
print(ways)
