from collections import namedtuple

Node = namedtuple("Node", ["left", "right"])

n = int(input())
tree = dict()
for _ in range(n):
    node, left, right = input().strip().split()
    tree[node] = Node(left, right)

in_ = []
pre = []
post = []

def inorder(v: str):
    if v == ".":
        return
    in_.append(v)
    inorder(tree[v].left)
    inorder(tree[v].right)

def preorder(v: str):
    if v == ".":
        return
    preorder(tree[v].left)
    pre.append(v)
    preorder(tree[v].right)

def postorder(v: str):
    if v == ".":
        return
    postorder(tree[v].left)
    postorder(tree[v].right)
    post.append(v)

inorder("A")
preorder("A")
postorder("A")

print("".join(in_))
print("".join(pre))
print("".join(post))
