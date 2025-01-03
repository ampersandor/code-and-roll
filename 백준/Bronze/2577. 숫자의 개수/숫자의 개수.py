from collections import Counter

a = int(input())
b = int(input())
c = int(input())

mul = str(a * b * c)

record = Counter(mul)

for i  in range(10):
    print(record[str(i)])