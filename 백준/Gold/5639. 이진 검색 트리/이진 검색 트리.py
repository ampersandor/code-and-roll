from sys import setrecursionlimit
setrecursionlimit(10**5)
preorder = []

while True:
    try:
        preorder.append(int(input()))
    except:
        break


def postorder(preorder):
    if not preorder:
        return

    root = preorder[0]
    i = 1
    while i < len(preorder) and preorder[i] < root:
        i += 1
    postorder(preorder[1:i])
    postorder(preorder[i:])
    print(root)

postorder(preorder)
