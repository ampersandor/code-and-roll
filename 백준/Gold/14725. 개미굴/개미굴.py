import sys
input = sys.stdin.readline


class Node:
    def __init__(self, key):
        self.key = key
        self.children = {}

    def has_child(self, key):
        return key in self.children

    def add_child(self, key):
        self.children[key] = (node:=Node(key))

        return node

    def update_child(self, key):
        if self.has_child(key):
            return self.children[key]

        return self.add_child(key)


class Trie:
    def __init__(self):
        self.head = Node(None)

    def insert(self, strings):
        cur = self.head
        for string in strings:
            cur = cur.update_child(string)

    def dfs(self, cur, depth):
        for k, v in sorted(cur.children.items()):
            print("--" * depth + k)
            self.dfs(v, depth + 1)


if __name__ == '__main__':
    N = int(input())
    trie = Trie()
    for _ in range(N):
        trie.insert(list(map(str, input().split()))[1:])

    trie.dfs(trie.head, 0)