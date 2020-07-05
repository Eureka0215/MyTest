package tools;

public class MyLink<E> implements Ilink<E> {
	
	private MyNode root;
	private int size = 0;
	
	//�ڲ��� ��ʾ�ڵ�
	class MyNode{
		private E data;
		private MyNode next;
		private MyNode before;
		
		public MyNode(E data)
		{
			this.data = data;
		}
	
	}
	//==============================����Ϊ�ڲ���=============================
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
			System.out.println("��ǰ����Ϊ�գ��޷����");
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
			System.out.println("��ǰ����Ϊ�գ��޷���ȡ");
			return null;
		}
		
		if(i>=this.size)
		{
			System.out.println("����������");
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
			System.out.println("��ǰ����Ϊ�գ��޷�����");
			return ;
		}
		if(data == null)
		{
			System.out.println("���벻��Ϊ��");
			return ;
		}
		if(i>=this.size)
		{
			System.out.println("����������");
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
			System.out.println("��ǰ����Ϊ�գ��޷�ɾ��");
			return ;
		}
		if(i>=this.size)
		{
			System.out.println("����������,�޷�ɾ��");
			return;
		}
		if(this.size == 1)  //���ֻ��һ���ڵ�  ֱ�Ӹ���rootΪnull ���³����˳�����
		{
			this.root = null;
			this.size --;
			return;
		}
		else               //�ж���ڵ�
		{
			for(int x=0;x<i;x++)
			{
				foot = foot.next;
			}
			if(foot == this.root)   //���Ҫɾ��ͷ�ڵ�
			{
				this.root.next.before = null;
				this.root = this.root.next;
				this.size--;
			}
			else                    //��ͷ�ڵ�
			{
				if(foot.next != null)                //�ҷ�β�ڵ�
				{
					foot.before.next = foot.next;
					foot.next.before = foot.before;
					this.size --;
				}
				else                //Ϊβ�ڵ�
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
			System.out.println("��ǰ����Ϊ�գ��޷��ж�");
			return false;
		}
		if(data == null)
		{
			System.out.println("���벻��Ϊ��");
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
			System.out.println("��ǰ����Ϊ�գ��޷��ж�");
			return ;
		}
		if(data == null)
		{
			System.out.println("���벻��Ϊ��");
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
			System.out.println("��ǰ�������������ݣ�����ɾ��");
			return;
		}
		
	}
	

}
