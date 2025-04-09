from collections import deque

n, m = map(int, input().split())

grid = [list(input().strip()) for _ in range(n)]
visited = set(grid[0][0])
DELTA = (0, 1, 0, -1, 0)
res = 0

def find(i, j):
    global res
    res = max(res, len(visited))
    for d in range(4):
        ni, nj = i + DELTA[d], j + DELTA[d+1]
        if 0 <= ni < n and 0 <= nj < m and grid[ni][nj] not in visited:
            visited.add(grid[ni][nj])
            find(ni, nj)
            visited.remove(grid[ni][nj])
find(0, 0)
print(res)