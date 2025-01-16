n = int(input())

nums = sorted(map(int, input().split()))

tot = 100

for i in range(n-1):
    tot += nums[i] / nums[-1] * 100

print(tot / n)