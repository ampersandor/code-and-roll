n = int(input())



coordinates = [tuple(map(int, input().split())) for _ in range(n)]
coordinates.append(coordinates[0])
res = 0

for i in range(n):
    x1, y1 = coordinates[i]
    x2, y2 = coordinates[i+1]
    res += x1 * y2 - x2 * y1

print(round(abs(res)/ 2, 1))
