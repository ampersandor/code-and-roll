word = input()



def failure(string):
    n = len(string)
    maxj = 0
    j = 0
    arr = [0] * n
    for i in range(1, n):
        while j > 0 and string[i] != string[j]:
            j = arr[j - 1]
        if string[i] == string[j]:
            j += 1
            arr[i] = j
        maxj = max(maxj, j)

    return maxj

res = 0
for i in range(len(word)):
    res = max(res, failure(word[i:]))

print(res)