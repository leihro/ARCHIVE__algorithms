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
	-postorder traversal: 先左再右，从leaf到root。实现跟前两个类似，先left，再right，最后标记顺序
	-layer traversal: 一层一层，从左到右，像graph中的bfs

- [Sort] 主要就是选择，交换和插入三种方案
* Bubble Sort - 两两比较，反序则交换 O(n*n)
* Select Sort - 通过后面每一个数与当前value对比，找到min，并与当前的换 O(n*n)
* Insert Sort - 每个值跟前面已经排好了的值对比，该在什么位置就插在什么位置 O(n*n)
* Shell Sort - 一定间距先对数列排序，分成子列，子列再用Insert <= O(n*n)
* Heap Sort - 优化选择排序，不断构造binary heap，将root也就是max value移动到尾部，循环完成排列 O(nlog(n))
* Merge Sort - 两组有序数归并成一组数，最终得到排序好的数列 O(nlog(n))
* Quick Sort - 选出中间值，左边的都比它小，右边的都大，如此迭代，排列好整个list O(nlog(n))

