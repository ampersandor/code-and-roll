from sys import stdin

input = stdin.readline

n = int(input())
arr = list(map(int, input().split()))

hashed = {k: i for i, k in enumerate(sorted(set(arr)))}

print(" ".join(map(lambda x: str(hashed[x]), arr)))