n = int(input())
first = list(map(int, input().split()))
second = list(map(int, input().split()))
second += second

def build_kmp_table(query):
    kmp = [0] * len(query)
    j = 0
    for i in range(1, len(query)):
        while j > 0 and query[i] != query[j]:
            j = kmp[j-1]
        if query[i] == query[j]:
            j += 1
        kmp[i] = j
    return kmp

def search(query, subject):
    kmp = build_kmp_table(query)
    j = 0
    for i in range(len(subject)):
        while j > 0 and subject[i] != query[j]:
            j = kmp[j-1]
        if subject[i] == query[j]:
            if j == len(query) - 1:
                return True
            j += 1

    return False


print("YES" if search(first, second) else "NO")