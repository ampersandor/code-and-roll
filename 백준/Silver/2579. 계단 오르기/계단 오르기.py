import sys

input = sys.stdin.readline

n = int(input())

stairs = [int(input()) for _ in range(n)]

if n < 3:
    print(sum(stairs))
    sys.exit(0)

dp = [[0, 0] for _ in range(n)]

dp[0] = [stairs[0], stairs[0]]
dp[1] = [stairs[1], stairs[0] + stairs[1]]

for i in range(2, n):
    dp[i][0] = max(dp[i-2]) + stairs[i]
    dp[i][1] = dp[i-1][0] + stairs[i]


print(max(dp[-1]))