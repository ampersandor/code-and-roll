from collections import Counter

n = int(input())
counter = Counter(map(int, input().split()))
m = int(input())
nums = list(map(int, input().split()))
print(" ".join(map(lambda num: str(counter.get(num, 0)), nums)))