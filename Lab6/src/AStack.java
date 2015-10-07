public class AStack<T> {
	public static class MyException extends RuntimeException
	{
		private static final long serialVersionUID = -244806549310243756L;
		public MyException()
		{
			super();
		}
		public MyException(String message)
		{
			super(message);
		}
	}
	
	private T[] arr;
	private int top;

	@SuppressWarnings("unchecked")
	public AStack(int size)
	{
		arr = (T[]) new Object[size];
		top = -1;
	}

	@SuppressWarnings("unchecked")
	public void push(T item)
	{
		if (top+1 == arr.length)
		{
			T[] newArr = (T[]) new Object[2*arr.length];
			for (int i = 0; i <= top; i++)
			{
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		arr[++top] = item;
	}

	public T pop()
	{
		if (isEmpty())
		{
			throw new MyException();
		}
		return arr[top--];
	}
	public T peek()
	{
		if (isEmpty())
		{
			throw new MyException();
		}
		return arr[top];
	}
	
	public boolean isEmpty()
	{
		return top < 0;
	}
}
