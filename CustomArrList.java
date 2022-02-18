package Farzan;

import java.io.Serializable;

public class CustomArrList <T> implements Serializable
{

    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomArrList()
    {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T num)
    {
        if (isFull())
        {
            resize();
        }
        data[size++] = num;
    }

    public boolean isFull()
    {
        return size == data.length;
    }

    private void resize()
    {
        Object[] temp = new Object[data.length*2];
        for (int i = 0; i < data.length; i++)
            temp[i] = data[i];
        data = temp;
    }

    public T remove()
    {
        T removed = (T)data[--size];
        return removed;
    }

    public T get_num(int index)
    {
        return (T)data[index];
    }

    public int Size()
    {
        return size;
    }

    public void set(int index, T data)
    {
        this.data[index] = data;
    }


}
