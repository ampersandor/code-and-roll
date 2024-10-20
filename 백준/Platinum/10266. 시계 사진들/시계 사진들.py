from sys import stdin

def failure(word):
    arr = [0] * len(word)
    j = 0
    for i in range(1, len(word)):
        while j > 0 and word[i] != word[j]:
            j = arr[j-1]
        if word[i] == word[j]:
            j += 1
            arr[i] = j
    return arr


def kmp(clock1, clock2):
    table = failure(clock2)
    j = 0
    for i in range(len(clock1)):
        while j > 0 and clock1[i] != clock2[j]:
            j = table[j-1]

        if clock1[i] == clock2[j]:
            if j == len(clock2) - 1:
                return True
            j += 1

    return False

input = stdin.readline
n = int(input())

clock1 = [0] * 360000
clock2 = [0] * 360000

for num in map(int, input().split()):
    clock1[num] = 1

for num in map(int, input().split()):
    clock2[num] = 1

clock1 += clock1

if kmp(clock1, clock2):
    print("possible")
else:
    print("impossible")
