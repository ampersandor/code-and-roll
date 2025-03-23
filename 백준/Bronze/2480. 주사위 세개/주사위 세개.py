from collections import Counter
counter = Counter(map(int, input().split()))

if len(counter) == 1:
    print(10000 + list(counter.keys())[0] * 1000)
elif len(counter) == 2:
    key = list(filter(lambda x: counter[x] == 2, counter.keys()))[0]
    print(1000 + key * 100)
else:
    print(max(counter.keys()) * 100)


