n, m = map(int, input().split())
grid = [input().strip() for _ in range(n)]

res = float('inf')

for a in range(n-7):
    for b in range(m-7):
        even_white, even_black = 0, 0
        for i in range(a, 8+a):
            for j in range(b, 8+b):
                k = i + j
                if k % 2 == 0:
                    if grid[i][j] == "B":
                        even_white += 1
                    else:
                        even_black += 1
                else:
                    if grid[i][j] == "W":
                        even_white += 1
                    else:
                        even_black += 1

        res = min(res, even_black, even_white)

print(res)