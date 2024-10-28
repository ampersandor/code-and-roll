
from sys import stdin
from collections import defaultdict

T = int(stdin.readline())
for i in range(T):

    N = int(stdin.readline())
    tree_up = defaultdict(list)
    for j in range(N-1):
        a, b = list(map(int, stdin.readline().split()))
        tree_up[b] = a
    a, b = list(map(int, stdin.readline().split()))

    a_roots = set()
    while a in tree_up:
        a_roots.add(a)
        a = tree_up[a]

    while b in tree_up:
        if b in a_roots :
            break
        b = tree_up[b]

    print(b)