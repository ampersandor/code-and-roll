n = int(input())
arr = list(map(int, input().split()))

hashed = dict()
for i, k in enumerate(sorted(set(arr))):
    hashed[k] = str(i)

print(" ".join(map(lambda x: hashed[x], arr)))