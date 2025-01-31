n = int(input())

arr = set(map(int, input().split()))

m = int(input())

queries = list(map(int, input().split()))

for query in queries:
    print(1 if query in arr else 0)