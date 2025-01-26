from sys import stdin

input = stdin.readline

n = int(input())

students = [tuple(map(int, input().split())) for _ in range(n)]

res = [0] * n
for i in range(n):
    count = 0
    for j in range(n):
        if i != j and students[i][0] < students[j][0] and students[i][1] < students[j][1]:
            count += 1

    res[i] = count + 1

print(" ".join(map(str, res)))