n = int(input())

for _ in range(n):
    tot = 0
    res = input().split("X")
    for ooo in res:
        tot += (len(ooo) * (len(ooo) + 1)) // 2
    print(tot)