from collections import defaultdict

n = int(input())


for _ in range(n):
    clothes = defaultdict(int)
    m = int(input())
    for _ in range(m):
        __, ctype = input().split()
        clothes[ctype] += 1
    res = 1
    for ctype, count in clothes.items():
        res *= (count + 1)
    print(res - 1)

