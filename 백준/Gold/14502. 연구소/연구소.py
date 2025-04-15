from itertools import combinations
from collections import deque
n, m = map(int, input().split())

grid = []
tot = 0
for i in range(n):
    row = list(map(int, input().split()))
    for j in range(m):
        if row[j] == 0:
            tot += 1
    grid.append(row)


def simulate(combs):
    count = tot - 3
    for comb in combs:
        i, j = comb // m, comb % m
        grid[i][j] = 1

    visited = [[False] * m for _ in range(n)]
    DELTA = (0, 1, 0, -1, 0)
    for i in range(n):
        for j in range(m):
            if grid[i][j] == 2:
                que = deque([(i, j)])
                visited[i][j] = True
                while que:
                    x, y = que.popleft()
                    for d in range(4):
                        nx, ny = x + DELTA[d], y + DELTA[d+1]
                        if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and grid[nx][ny] == 0:
                            visited[nx][ny] = True
                            que.append((nx, ny))
                            count -= 1
    for comb in combs:
        i, j = comb // m, comb % m
        grid[i][j] = 0

    return count

res = 0

for combs in combinations(range(n * m), 3):
    for comb in combs:
        i, j = comb // m, comb % m
        if grid[i][j] > 0:
            break
    else:
        res = max(res, simulate(combs))

print(res)