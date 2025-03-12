from collections import deque

n = int(input())
edges = [list(map(int, input().split())) for _ in range(n)]
res = [[0] * n for _ in range(n)]


for i in range(n):
    que = deque([i])
    while que:
        node = que.popleft()
        for child in range(n):
            if edges[node][child] and not res[i][child]:
                res[i][child] = 1
                que.append(child)

for row in res:
    print(*row)