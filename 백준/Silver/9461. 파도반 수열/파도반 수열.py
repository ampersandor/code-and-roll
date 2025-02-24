from sys import stdin

input = stdin.readline
tests = int(input())

for _ in range(tests):
    n = int(input())

    dp = [0, 1, 1, 1, 2, 2]
    if n < len(dp):
        print(dp[n])
    else:
        for i in range(6, n + 1):
            dp.append(dp[i-1] + dp[i-5])
        print(dp[-1])