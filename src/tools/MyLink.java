package tools;

public class MyLink<E> implements Ilink<E> {
	
	private MyNode root;
	private int size = 0;
	
	//内部类 表示节点
	class MyNode{
		private E data;
		private MyNode next;
		private MyNode before;
		
		public MyNode(E data)
		{
			this.data = data;
		}
	
	}
	//==============================以上为内部类=============================
	public void add(E data)
	{
		MyNode foot = this.root;
		
		if (data == null)
		{
			return;
		}
		if(root == null)
		{
			this.root = new MyNode(data);
		}
		else
		{
			while(foot.next!=null)
			{
				foot = foot.next;
			}
			foot.next = new MyNode(data);
			foot.next.before = foot;
		}
		
		this.size ++;
			
	}
	
	public int size()
	{
		return this.size;
	}
	
	public boolean isEmpty()
	{
		if(this.root == null)
			return true;
		else
			return false;
	}
	
	public Object[] toArray()
	{
		if(this.isEmpty())
		{
			System.out.println("当前链表为空，无法输出");
			return null;
		}
		
		Object arrays[] = new Object[this.size];
		MyNode foot = this.root;
		for(int i=0;i<this.size;i++)
		{
			if(foot != null)
			{
				arrays[i] = foot.data;
				foot = foot.next;
			}
			else
			{
				break;
			}
		}
		
		return arrays;
	}
	
	public E getNodeData(int i)
	{
		MyNode foot = this.root;
		if(this.isEmpty())
		{
			System.out.println("当前链表为空，无法获取");
			return null;
		}
		
		if(i>=this.size)
		{
			System.out.println("超出链表长度");
			return null;
		}
		for(int x=0;x<i;x++)
		{
			foot = foot.next;
		}
		return foot.data;
	}
	
	public void updateNode(int i,E data)
	{
		MyNode foot = this.root;
		if(this.isEmpty())
		{
			System.out.println("当前链表为空，无法更新");
			return ;
		}
		if(data == null)
		{
			System.out.println("输入不能为空");
			return ;
		}
		if(i>=this.size)
		{
			System.out.println("超出链表长度");
			return;
		}
		for(int x=0;x<i;x++)
		{
			foot = foot.next;
		}
		foot.data = data;
	}
	
	public void deleteNode(int i)
	{
		MyNode foot = this.root;
		if(this.isEmpty())
		{
			System.out.println("当前链表为空，无法删除");
			return ;
		}
		if(i>=this.size)
		{
			System.out.println("超出链表长度,无法删除");
			return;
		}
		if(this.size == 1)  //如果只有一个节点  直接更改root为null 更新长度退出即可
		{
			this.root = null;
			this.size --;
			return;
		}
		else               //有多个节点
		{
			for(int x=0;x<i;x++)
			{
				foot = foot.next;
			}
			if(foot == this.root)   //如果要删除头节点
			{
				this.root.next.before = null;
				this.root = this.root.next;
				this.size--;
			}
			else                    //非头节点
			{
				if(foot.next != null)                //且非尾节点
				{
					foot.before.next = foot.next;
					foot.next.before = foot.before;
					this.size --;
				}
				else                //为尾节点
				{
					foot.before.next = null;
					this.size --;
				}
				
			}
		}
	}
	
	public boolean contain(E data)
	{
		MyNode foot = this.root;
		if(this.isEmpty())
		{
			System.out.println("当前链表为空，无法判断");
			return false;
		}
		if(data == null)
		{
			System.out.println("输入不能为空");
			return false;
		}
		for(int x=0;x<this.size;x++)
		{
			if(foot.data.equals(data))
			{
				return true;
			}
			else
			{
				foot = foot.next;
			}
			
		}
		return false;
	}
	
	public void clear()
	{
		this.root = null;
		this.size = 0;
	}
	
	public void deleteData(E data)
	{
		MyNode foot = this.root;
		if(this.isEmpty())
		{
			System.out.println("当前链表为空，无法判断");
			return ;
		}
		if(data == null)
		{
			System.out.println("输入不能为空");
			return ;
		}
		if(this.contain(data))
		{
			int x=0;
			while(foot!=null)
			{
				if(foot.data.equals(data))
				{
					this.deleteNode(x);
					foot=this.root;
					x=0;
				}
				else
				{
					foot = foot.next;
					x++;
				}
				
			}
		}
		else
		{
			System.out.println("当前链表不包含该数据，无需删除");
			return;
		}
		
	}
	

}
