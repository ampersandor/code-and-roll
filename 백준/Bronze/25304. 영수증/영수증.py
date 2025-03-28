x = int(input())
n = int(input())

tot = 0
for _ in range(n):
    a, b = map(int, input().split())
    tot += a * b

print("Yes" if tot == x else "No")