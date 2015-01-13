# Algorithms
commonly used algorithms, list and classified

## Content
- [math](#math)
	-[prime number]
- [sort](#sort)
- [search](#search)

### Math

### Sort

### Search


## TOdo
- [Graph] － 图可以用array实现，"A"=>array("B","C"); A的两个子结点是B和C
* bfs - 用Queue实现，把图当作树分层，每找到一个新的neighbour node，enqueue进去，找完所有的neighbour, dequeque当前的node，
* dfs - recursive dfs每一个node

- [Tree] - 一个root，多个leaf，每个中间node有一个parent，多个children
* binary Tree － 每个node最多两个children
* Full Binary Tree(满二叉树) - 每一个node都有两个children，并且leaf是满的
* Complete Binary Tree（完全二叉树）- 不全的满二叉树，按层编号，顺序和Full Binary Tree一样
	-preorder traversal: 从root开始，先左后右，从根到叶，像graph的dfs。实现用recursive就行
	-inorder traversal: 从root分开，先左子树，再root，再右半边最右。实现跟preorder类似，只不过先进行left的traverse再标记顺序，也是recursive
	-postorder traversal: 先左再右，从leaf到root
	-layer traversal: 一层一层，从左到右，像graph中的bfs
