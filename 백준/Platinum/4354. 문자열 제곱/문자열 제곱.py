from sys import stdin

def failure(word):
    j = 0
    arr = [0] * len(word)
    for i in range(1, len(word)):
        while j > 0 and word[i] != word[j]:
            j = arr[j-1]
        if word[i] == word[j]:
            j += 1
            arr[i] = j

    if len(word) % (len(word) - arr[-1]):
        return 1

    return len(word) // (len(word) - arr[-1])




input = stdin.readline
while (x:=input().strip()) != ".":
    print(failure(x))


"""
abaaba
2


"""