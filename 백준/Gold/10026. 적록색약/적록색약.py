from collections import deque

n = int(input())

grid = [input().strip()for _ in range(n)]

visited = [[[False, False] for _ in range(n)] for _ in range(n)]
DELTA = (0, 1, 0, -1, 0)
res = [0, 0]

def bfs(i, j, k):
    que = deque([(i, j)])
    while que:
        i, j = que.popleft()
        for d in range(4):
            ni, nj = i + DELTA[d], j + DELTA[d + 1]
            if 0 <= ni < n and 0 <= nj < n and not visited[ni][nj][k]:
                if k == 0 and grid[i][j] == grid[ni][nj]: # normal
                    visited[ni][nj][k] = True
                    que.append((ni, nj))
                elif k == 1 and (grid[i][j] == grid[ni][nj] or {grid[ni][nj], grid[i][j]}.issubset({"R", "G"})):
                    visited[ni][nj][k] = True
                    que.append((ni, nj))

for x in range(n):
    for y in range(n):
        for q in range(2):
            if not visited[x][y][q]:
                visited[x][y][q] = True
                bfs(x, y, q)
                res[q] += 1

print(*res)
