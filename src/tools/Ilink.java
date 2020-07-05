package tools;

public interface Ilink<E> {
	
	public void add(E data);  //向链表中添加节点及数据
	public int size();        //显示当前链表中元素个数
	public boolean isEmpty(); //判断当前链表是否为空
	public Object[] toArray(); //将链表内的数据集合返回给一个对象数组
	public E getNodeData(int i);   //返回指定节点的数据 索引从0开始
	public void updateNode(int i,E data); //修改指定节点的数据 索引从0开始
	public void deleteNode(int i); //删除指定节点的数据 索引从0开始
	public boolean contain(E data); //判断数据是否存在于链表中
	public void deleteData(E data); //删除指定数据的节点
	public void clear(); //清空链表
}
