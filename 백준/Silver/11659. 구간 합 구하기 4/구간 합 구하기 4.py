from sys import stdin, stdout

read = stdin.readline
write = stdout.write

n, m = map(int, read().split())

nums = [0] + list(map(int, read().split()))
for i in range(1, n+1):
    nums[i] += nums[i-1]

for _ in range(m):
    i, j = map(int, read().split())
    write(str(nums[j] - nums[i-1]) + "\n")