# leetcode 做题笔记——简洁版(复习用)

## 102题 二叉树的层序遍历

<img src="picture/102.png" height=300px>

层序遍历首先会想到使用queue，但是这还是不够的，每一层的结果都被保存到一个list中。
**设计len**来保存当前层级的节点个数，**计数count**进行记录，一旦count==len 则将layer数组添加到答案中，并清空数组，重置count与len，直到队列为空。

相关练习 
[107.二叉树的层次遍历 II](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)&nbsp;&nbsp;&nbsp;
[103.二叉树的锯齿形层次遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)