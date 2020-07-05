package tools;

public interface Ilink<E> {
	
	public void add(E data);  //����������ӽڵ㼰����
	public int size();        //��ʾ��ǰ������Ԫ�ظ���
	public boolean isEmpty(); //�жϵ�ǰ�����Ƿ�Ϊ��
	public Object[] toArray(); //�������ڵ����ݼ��Ϸ��ظ�һ����������
	public E getNodeData(int i);   //����ָ���ڵ������ ������0��ʼ
	public void updateNode(int i,E data); //�޸�ָ���ڵ������ ������0��ʼ
	public void deleteNode(int i); //ɾ��ָ���ڵ������ ������0��ʼ
	public boolean contain(E data); //�ж������Ƿ������������
	public void deleteData(E data); //ɾ��ָ�����ݵĽڵ�
	public void clear(); //�������
}
