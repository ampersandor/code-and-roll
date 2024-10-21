import sys
input = sys.stdin.readline


class Node():
    def __init__(self, key):
        self.key = key
        self.children = {}


class Trie:
    def __init__(self):
        self.head = Node(None)

    def insert(self, strings):
        current_node = self.head

        for string in strings:
            # 없다면 생성
            if string not in current_node.children:
                current_node.children[string] = Node(string)

            current_node = current_node.children[string]

    def dfs(self, current_node, depth):
        for k, v in sorted(current_node.children.items()):

            for _ in range(depth):
                print("--", end="")
            print(k)

            self.dfs(v, depth + 1)


if __name__ == '__main__':
    N = int(input())

    trie = Trie()
    for _ in range(N):
        cur_input = list(map(str, input().split()))
        trie.insert(cur_input[1:])

    trie.dfs(trie.head, 0)