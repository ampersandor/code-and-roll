from sys import stdin, setrecursionlimit
from collections import defaultdict

setrecursionlimit(10**5)

class Tree:
    def __init__(self, x):
        self.x = x
        self.n_child = 1

def make_tree(parent, node):
    tree = Tree(node)
    trees[node] = tree
    for child in edges[node]:
        if child != parent:
            tree.n_child += make_tree(node, child).n_child

    return tree

input = stdin.readline
n, r, q = map(int, input().split())
edges = defaultdict(list)
trees = dict()
for _ in range(n-1):
    a, b = map(int, input().split())
    edges[a].append(b)
    edges[b].append(a)


root = make_tree(r, r)

for _ in range(q):
    idx = int(input())
    print(trees[idx].n_child)