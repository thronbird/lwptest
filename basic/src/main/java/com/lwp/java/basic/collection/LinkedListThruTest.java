package com.lwp.java.basic.collection;

/**
 * Created by liwanping on 2018-02-20
 */
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/*
 * @desc ����LinkedList�ļ��ֱ�����ʽ��Ч��
 *
 * @author skywang
 */
public class LinkedListThruTest {
    public static void main(String[] args) {
        // ͨ��Iterator����LinkedList
        iteratorLinkedListThruIterator(getLinkedList()) ;

        // ͨ������������ʱ���LinkedList
        iteratorLinkedListThruForeach(getLinkedList()) ;

        // ͨ��forѭ���ı��������ʱ���LinkedList
        iteratorThroughFor2(getLinkedList()) ;

        // ͨ��PollFirst()����LinkedList
        iteratorThroughPollFirst(getLinkedList()) ;

        // ͨ��PollLast()����LinkedList
        iteratorThroughPollLast(getLinkedList()) ;

        // ͨ��removeFirst()����LinkedList
        iteratorThroughRemoveFirst(getLinkedList()) ;

        // ͨ��removeLast()����LinkedList
        iteratorThroughRemoveLast(getLinkedList()) ;
    }

    private static LinkedList getLinkedList() {
        LinkedList llist = new LinkedList();
        for (int i=0; i<100000; i++)
            llist.addLast(i);

        return llist;
    }
    /**
     * ͨ�������������LinkedList
     */
    private static void iteratorLinkedListThruIterator(LinkedList<Integer> list) {
        if (list == null)
            return ;

        // ��¼��ʼʱ��
        long start = System.currentTimeMillis();

        for(Iterator iter = list.iterator(); iter.hasNext();)
            iter.next();

        // ��¼����ʱ��
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorLinkedListThruIterator��" + interval+" ms");
    }

    /**
     * ͨ������������ʱ���LinkedList
     */
    private static void iteratorLinkedListThruForeach(LinkedList<Integer> list) {
        if (list == null)
            return ;

        // ��¼��ʼʱ��
        long start = System.currentTimeMillis();

        int size = list.size();
        for (int i=0; i<size; i++) {
            list.get(i);
        }
        // ��¼����ʱ��
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorLinkedListThruForeach��" + interval+" ms");
    }

    /**
     * ͨ������һ��forѭ��������LinkedList
     */
    private static void iteratorThroughFor2(LinkedList<Integer> list) {
        if (list == null)
            return ;

        // ��¼��ʼʱ��
        long start = System.currentTimeMillis();

        for (Integer integ:list)
            ;

        // ��¼����ʱ��
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorThroughFor2��" + interval+" ms");
    }

    /**
     * ͨ��pollFirst()������LinkedList
     */
    private static void iteratorThroughPollFirst(LinkedList<Integer> list) {
        if (list == null)
            return ;

        // ��¼��ʼʱ��
        long start = System.currentTimeMillis();
        while(list.pollFirst() != null)
            ;

        // ��¼����ʱ��
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorThroughPollFirst��" + interval+" ms");
    }

    /**
     * ͨ��pollLast()������LinkedList
     */
    private static void iteratorThroughPollLast(LinkedList<Integer> list) {
        if (list == null)
            return ;

        // ��¼��ʼʱ��
        long start = System.currentTimeMillis();
        while(list.pollLast() != null)
            ;

        // ��¼����ʱ��
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorThroughPollLast��" + interval+" ms");
    }

    /**
     * ͨ��removeFirst()������LinkedList
     */
    private static void iteratorThroughRemoveFirst(LinkedList<Integer> list) {
        if (list == null)
            return ;

        // ��¼��ʼʱ��
        long start = System.currentTimeMillis();
        try {
            while(list.removeFirst() != null)
                ;
        } catch (NoSuchElementException e) {
        }

        // ��¼����ʱ��
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorThroughRemoveFirst��" + interval+" ms");
    }

    /**
     * ͨ��removeLast()������LinkedList
     */
    private static void iteratorThroughRemoveLast(LinkedList<Integer> list) {
        if (list == null)
            return ;

        // ��¼��ʼʱ��
        long start = System.currentTimeMillis();
        try {
            while(list.removeLast() != null)
                ;
        } catch (NoSuchElementException e) {
        }

        // ��¼����ʱ��
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("iteratorThroughRemoveLast��" + interval+" ms");
    }

}
