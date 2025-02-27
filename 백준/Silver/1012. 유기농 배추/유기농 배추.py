from collections import deque

DELTA = [0, 1, 0, -1, 0]

def bfs(x, y, grid, n, m):
    que = deque([(x, y)])
    while que:
        i, j = que.popleft()
        for d in range(4):
            ni, nj = i + DELTA[d], j + DELTA[d + 1]
            if 0 <= ni < n and 0 <= nj < m and grid[ni][nj]:
                grid[ni][nj] = 0
                que.append((ni, nj))


def solve():
    n, m, k = map(int, input().split())
    grid = [[0] * m for _ in range(n)]
    for _ in range(k):
        x, y = map(int, input().split())
        grid[x][y] = 1
    res = 0
    for i in range(n):
        for j in range(m):
            if grid[i][j]:
                grid[i][j] = 0
                bfs(i, j, grid, n, m)
                res += 1
    print(res)

t = int(input())


for _ in range(t):
    solve()