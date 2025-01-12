count = 1
start = 1
n = int(input())

while start < n:
    start += count * 6
    count += 1

print(count)