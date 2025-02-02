n = int(input())
INF = float('inf')

dp = [INF] * (n + 1)

if n < 5:
    if n == 3:
        print(1)
    else:
        print(-1)
    exit(0)

dp[3] = 1
dp[5] = 1

for i in range(6, n + 1):
    dp[i] = min(dp[i-3], dp[i-5]) + 1

print(-1 if dp[-1] == INF else dp[-1])