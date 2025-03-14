from collections import deque
from sys import stdin, stdout

read = stdin.readline
write = stdout.write

DELTA = (0, 1, 0, -1, 0)

def bfs(x, y, n, m, res, grid):
    visited = [[False] * m for _ in range(n)]
    visited[x][y] = True
    que = deque([(x, y, 0)])
    while que:
        i, j, c = que.popleft()
        res[i][j] = c
        for d in range(4):
            ni, nj = i + DELTA[d], j + DELTA[d+1]
            if 0 <= ni < n and 0 <= nj < m and grid[ni][nj] == 1 and not visited[ni][nj]:
                visited[ni][nj] = True
                que.append((ni, nj, c + 1))

def solve():
    n, m = map(int, read().split())
    grid = []
    res = [[-1] * m for _ in range(n)]
    sx, sy = 0, 0

    for i in range(n):
        row = list(map(int, read().split()))
        grid.append(row)
        for j in range(m):
            if row[j] == 2:
                sx, sy = i, j
            elif row[j] == 0:
                res[i][j] = 0
    bfs(sx, sy, n, m, res, grid)
    for row in res:
        write(" ".join(map(str, row)) + "\n")


solve()