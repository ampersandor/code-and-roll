
n = int(input())
arr = list(map(int, input().split()))
t = int(input())
count = 0
for num in arr:
    if num == t:
        count += 1
print(count)