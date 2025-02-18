n = int(input())
res = 0
times = sorted(map(int, input().split()))

for i, time in enumerate(times):
    res += time * (n - i)

print(res)