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
	
	// 현재 iterator가 가리키는 곳에 값을 추가한다.
	public void add(T data)
	{
		this.buffer.add(this.iter, data);
	}
	// 현재 iterator가 가리키는 곳의 데이터를 삭제하고 iterator를 한칸 뒤로 보낸다.
	public void remove()
	{
		this.buffer.remove(this.iter);
	}
	// 현재 iterator가 가리키는 값을 수정한다.
	public T set(T data)
	{
		return this.buffer.set(this.iter,data);
	}
	public T set(int index, T data)
	{
		return this.buffer.set(index,data);
	}
	// 현재 iterator가 가리키는 값을 리턴한다.
	public T get()
	{
		return (T)this.buffer.get(this.iter);
	}
	// 전달된 index에 해당하는 값을 전달한다.
	public T get(int index)
	{
		return (T)this.buffer.get(index);
	}
	public T getPrev()
	{
		if(this.iter-1 < 0)	// 맨 앞 단어일 경우
			return null;
		else
			return (T)this.buffer.get(this.iter-1);
	}
	// 현재 iterator가 가리키는 곳의 값과 parameter 값을 비교한다.
	// equals overriding을 해야함
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
	public byte next()	 // iterator를 다음으로 이동
	{
		if(!hasNext())	// 다음 공간이 없을 경우
			return 0;
		this.iter++;
			return 1;
	}
	public byte prev()
	{
		if(!hasPrev())	// 이전 공간이 없을 경우
			return 0;
		this.iter--;
		return 1;
	}

	/* 단위테스트 코드
	public static void main(String[] args)
	{ 
		GenBuffer<Character> strBuffer2 = new GenBuffer<Character>(10);
		strBuffer2.add('되');
		strBuffer2.add('라');
		strBuffer2.add('고');

		for(int i = 0 ; i<3 ; i++)
		{
			System.out.print(strBuffer2.get());
			strBuffer2.next();
		}
		System.out.println();
		Character[] str = new Character[]{'지','금','은', ' ' , '점', '심','시','간','이','다'}; 
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