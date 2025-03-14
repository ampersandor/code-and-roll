from collections import deque


n, m = map(int, input().split())
DELTA = (0, 1, 0, -1, 0)

grid = []
res = [[-1] * m for _ in range(n)]
start: tuple = ()
visited = [[False] * m for _ in range(n)]

for i in range(n):
    row = list(map(int, input().split()))
    grid.append(row)
    for j in range(m):
        if row[j] == 2:
            start = i, j
        elif row[j] == 0:
            res[i][j] = 0


def bfs(x, y):
    que = deque([(x, y, 0)])
    while que:
        i, j, c = que.popleft()
        res[i][j] = c
        for d in range(4):
            ni, nj = i + DELTA[d], j + DELTA[d+1]
            if 0 <= ni < n and 0 <= nj < m and grid[ni][nj] == 1 and not visited[ni][nj]:
                visited[ni][nj] = True
                que.append((ni, nj, c + 1))

visited[start[0]][start[1]] = True
bfs(*start)
for row in res:
    print(*row)
