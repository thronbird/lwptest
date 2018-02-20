package Collection;

/**
 * Created by liwanping on 2018-02-20
 */
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/*
 * @desc LinkedList���Գ���
 *
 * @author skywang
 * @email  kuiwu-wang@163.com
 */
public class LinkedListTest {
    public static void main(String[] args) {
        // ����LinkedList��API
        testLinkedListAPIs() ;

        // ��LinkedList���� LIFO(����ȳ�)�Ķ�ջ
        useLinkedListAsLIFO();

        // ��LinkedList���� FIFO(�Ƚ��ȳ�)�Ķ���
        useLinkedListAsFIFO();
    }

    /*
     * ����LinkedList�в���API
     */
    private static void testLinkedListAPIs() {
        String val = null;
        //LinkedList llist;
        //llist.offer("10");
        // �½�һ��LinkedList
        LinkedList llist = new LinkedList();
        //---- ��Ӳ��� ----
        // �������1,2,3
        llist.add("1");
        llist.add("2");
        llist.add("3");

        // ����4����ӵ���һ��λ��
        llist.add(1, "4");


        System.out.println("\nTest \"addFirst(), removeFirst(), getFirst()\"");
        // (01) ����10����ӵ���һ��λ�á�  ʧ�ܵĻ����׳��쳣��
        llist.addFirst("10");
        System.out.println("llist:"+llist);
        // (02) ����һ��Ԫ��ɾ����        ʧ�ܵĻ����׳��쳣��
        System.out.println("llist.removeFirst():"+llist.removeFirst());
        System.out.println("llist:"+llist);
        // (03) ��ȡ��һ��Ԫ�ء�          ʧ�ܵĻ����׳��쳣��
        System.out.println("llist.getFirst():"+llist.getFirst());


        System.out.println("\nTest \"offerFirst(), pollFirst(), peekFirst()\"");
        // (01) ����10����ӵ���һ��λ�á�  ����true��
        llist.offerFirst("10");
        System.out.println("llist:"+llist);
        // (02) ����һ��Ԫ��ɾ����        ʧ�ܵĻ�������null��
        System.out.println("llist.pollFirst():"+llist.pollFirst());
        System.out.println("llist:"+llist);
        // (03) ��ȡ��һ��Ԫ�ء�          ʧ�ܵĻ�������null��
        System.out.println("llist.peekFirst():"+llist.peekFirst());


        System.out.println("\nTest \"addLast(), removeLast(), getLast()\"");
        // (01) ����20����ӵ����һ��λ�á�  ʧ�ܵĻ����׳��쳣��
        llist.addLast("20");
        System.out.println("llist:"+llist);
        // (02) �����һ��Ԫ��ɾ����        ʧ�ܵĻ����׳��쳣��
        System.out.println("llist.removeLast():"+llist.removeLast());
        System.out.println("llist:"+llist);
        // (03) ��ȡ���һ��Ԫ�ء�          ʧ�ܵĻ����׳��쳣��
        System.out.println("llist.getLast():"+llist.getLast());


        System.out.println("\nTest \"offerLast(), pollLast(), peekLast()\"");
        // (01) ����20����ӵ���һ��λ�á�  ����true��
        llist.offerLast("20");
        System.out.println("llist:"+llist);
        // (02) ����һ��Ԫ��ɾ����        ʧ�ܵĻ�������null��
        System.out.println("llist.pollLast():"+llist.pollLast());
        System.out.println("llist:"+llist);
        // (03) ��ȡ��һ��Ԫ�ء�          ʧ�ܵĻ�������null��
        System.out.println("llist.peekLast():"+llist.peekLast());



        // ����3��Ԫ������300����������LinkedList��ʹ�ô˲�������ΪЧ�ʵͣ�
        llist.set(2, "300");
        // ��ȡ��3��Ԫ�ء���������LinkedList��ʹ�ô˲�������ΪЧ�ʵͣ�
        System.out.println("\nget(3):"+llist.get(2));


        // ---- toArray(T[] a) ----
        // ��LinkedListת��Ϊ����
        String[] arr = (String[])llist.toArray(new String[0]);
        for (String str:arr)
            System.out.println("str:"+str);

        // �����С
        System.out.println("size:"+llist.size());
        // ���LinkedList
        llist.clear();
        // �ж�LinkedList�Ƿ�Ϊ��
        System.out.println("isEmpty():"+llist.isEmpty()+"\n");

    }

    /**
     * ��LinkedList���� LIFO(����ȳ�)�Ķ�ջ
     */
    private static void useLinkedListAsLIFO() {
        System.out.println("\nuseLinkedListAsLIFO");
        // �½�һ��LinkedList
        LinkedList stack = new LinkedList();

        // ��1,2,3,4��ӵ���ջ��
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        // ��ӡ��ջ��
        System.out.println("stack:"+stack);

        // ɾ����ջ��Ԫ�ء�
        System.out.println("stack.pop():"+stack.pop());

        // ȡ����ջ��Ԫ�ء�
        System.out.println("stack.peek():"+stack.peek());

        // ��ӡ��ջ��
        System.out.println("stack:"+stack);
    }

    /**
     * ��LinkedList���� FIFO(�Ƚ��ȳ�)�Ķ���
     */
    private static void useLinkedListAsFIFO() {
        System.out.println("\nuseLinkedListAsFIFO");
        // �½�һ��LinkedList
        LinkedList queue = new LinkedList();

        // ��10,20,30,40��ӵ����С�ÿ�ζ��ǲ��뵽ĩβ
        queue.add("10");
        queue.add("20");
        queue.add("30");
        queue.add("40");
        // ��ӡ�����С�
        System.out.println("queue:"+queue);

        // ɾ��(���еĵ�һ��Ԫ��)
        System.out.println("queue.remove():"+queue.remove());

        // ��ȡ(���еĵ�һ��Ԫ��)
        System.out.println("queue.element():"+queue.element());

        // ��ӡ�����С�
        System.out.println("queue:"+queue);
    }
}