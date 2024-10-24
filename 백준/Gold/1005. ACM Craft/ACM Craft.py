from sys import stdin
from collections import defaultdict, deque

"""
2 ≤ N ≤ 1000
1 ≤ K ≤ 100,000
1 ≤ X, Y, W ≤ N
0 ≤ Di ≤ 100,000, Di는 정수
"""


input = stdin.readline

T = int(input())

for _ in range(T):
    n, k = map(int, input().split())
    costs = list(map(int, input().split()))
    graph = defaultdict(list)
    in_degree = [0] * n
    for _ in range(k):
        a, b = map(lambda x: int(x) - 1, input().split())
        graph[a].append(b)
        in_degree[b] += 1

    w = int(input()) - 1
    que = deque()
    res = [0] * n

    for i in range(n):
        if in_degree[i] == 0:
            que.append(i)
            res[i] = costs[i]
    while que:
        node = que.popleft()
        if node == w:
            break
        for child in graph[node]:
            in_degree[child] -= 1
            if in_degree[child] == 0:
                que.append(child)
            res[child] = max(res[child], costs[child] + res[node])

    # print(res)
    print(res[w])

