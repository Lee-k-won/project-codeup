import java.util.*;

public class GenBuffer<T>
{
	private ArrayList<T> buffer;
	private int length;
	private int iter;

	public GenBuffer()
	{
		this(0,null);
	}
	public GenBuffer(int length)
	{
		this(length, null);
	}
	public GenBuffer(T initData, int length)
	{
		this.buffer = new ArrayList<T>();
		this.length = length;
		this.iter = 0;
		fill(length, initData);
	}
	public GenBuffer(int length, T[] buffer)
	{
		if(buffer == null)
			this.buffer = new ArrayList<T>();
		else
			this.buffer = new ArrayList<T>(Arrays.asList(buffer));
		this.length = length;	
		this.iter = 0;
	}
	public void fill(int num, T data)
	{
		for(int i = 0 ; i < num ; i++)
		{
			this.buffer.add(data);
		}
	}
	public void init(int length, T[] buffer)
	{
		for(int i = 0 ; i<length ; i ++)
		{
			this.buffer.add(buffer[i]);
		}
		this.length = length;
	}
	public void setBuffer(ArrayList<T> buffer)
	{
		this.buffer = buffer;
	}
	public void setLength(int length)
	{
		this.length = length;
	}
	public void setIter(int iter)
	{
		this.iter = iter;
	}
	public ArrayList<T> getBuffer()
	{
		return this.buffer;
	}
	public int getLength()
	{
		return this.length;
	}
	public int getIter()
	{
		return this.iter;
	}

	/* manipulate arrayList */
	
	// ���� iterator�� ����Ű�� ���� ���� �߰��Ѵ�.
	public void add(T data)
	{
		this.buffer.add(this.iter, data);
	}
	// ���� iterator�� ����Ű�� ���� �����͸� �����ϰ� iterator�� ��ĭ �ڷ� ������.
	public void remove()
	{
		this.buffer.remove(this.iter);
	}
	// ���� iterator�� ����Ű�� ���� �����Ѵ�.
	public T set(T data)
	{
		return this.buffer.set(this.iter,data);
	}
	public T set(int index, T data)
	{
		return this.buffer.set(index,data);
	}
	// ���� iterator�� ����Ű�� ���� �����Ѵ�.
	public T get()
	{
		return (T)this.buffer.get(this.iter);
	}
	// ���޵� index�� �ش��ϴ� ���� �����Ѵ�.
	public T get(int index)
	{
		return (T)this.buffer.get(index);
	}
	public T getPrev()
	{
		if(this.iter-1 < 0)	// �� �� �ܾ��� ���
			return null;
		else
			return (T)this.buffer.get(this.iter-1);
	}
	// ���� iterator�� ����Ű�� ���� ���� parameter ���� ���Ѵ�.
	// equals overriding�� �ؾ���
	public boolean checkData(T data)
	{
		return this.get().equals(data);
	}
	/* manipulate iterator */
		
	public boolean hasNext()
	{
		return length-1 >this.iter;
	}
	public boolean hasPrev()
	{
		return 0<this.iter;
	}
	public byte next()	 // iterator�� �������� �̵�
	{
		if(!hasNext())	// ���� ������ ���� ���
			return 0;
		this.iter++;
			return 1;
	}
	public byte prev()
	{
		if(!hasPrev())	// ���� ������ ���� ���
			return 0;
		this.iter--;
		return 1;
	}

	/* �����׽�Ʈ �ڵ�
	public static void main(String[] args)
	{ 
		GenBuffer<Character> strBuffer2 = new GenBuffer<Character>(10);
		strBuffer2.add('��');
		strBuffer2.add('��');
		strBuffer2.add('��');

		for(int i = 0 ; i<3 ; i++)
		{
			System.out.print(strBuffer2.get());
			strBuffer2.next();
		}
		System.out.println();
		Character[] str = new Character[]{'��','��','��', ' ' , '��', '��','��','��','��','��'}; 
		GenBuffer<Character> strBuffer = new GenBuffer<Character>(str.length,str);
		
		for(int i = 0 ; i<str.length ; i++)
		{
			System.out.print(strBuffer.get());
			strBuffer.next();
		}
		System.out.println();
		Integer[] dat= new Integer[]{1,2,3,4,5,6,7,8,9,10}; 
		GenBuffer<Integer> datBuffer = new GenBuffer<Integer>(dat.length,dat);
		
		for(int i = 0 ; i<dat.length ; i++)
		{
			System.out.print(datBuffer.get());
			datBuffer.next();
		}
		System.out.println();
	}
	*/
}