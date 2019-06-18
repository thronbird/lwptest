package com.lwptest.basic.nio;


import java.io.IOException;
import java.io.RandomAccessFile;

public class randomaccesstest {
    public static void main(String[] args) throws IOException {
        write();
        test();
    }

    private static void test() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("D:/employee.txt", "r");
        int len = 8;
        raf1.skipBytes(12); // ������һ��Ա������Ϣ��������8�ֽڣ�����4�ֽ�
        System.out.println("�ڶ���Ա������Ϣ��");
        String str = "";
        for (int i = 0; i < len; i++) {
            str = str + (char) raf1.readByte();
        }
        System.out.println("name��" + str);
        System.out.println("age��" + raf1.readInt());
        System.out.println("��һ��Ա������Ϣ��");
        raf1.seek(0);
        str = "";
        for (int i = 0; i < len; i++) {
            str = str + (char) raf1.readByte();
        }
        System.out.println("name��" + str);
        System.out.println("age��" + raf1.readInt());
        System.out.println("������Ա������Ϣ��");
        raf1.skipBytes(12); // �����ڶ���Ա������Ϣ
        str = "";
        for (int i = 0; i < len; i++) {
            str = str + (char) raf1.readByte();
        }
        System.out.println("name��" + str.trim());
        System.out.println("age��" + raf1.readInt());
        raf1.close();
    }

    public static void write() throws IOException {
        Employee e1 = new Employee("zhangsan", 23);
        Employee e2 = new Employee("lisi", 24);
        Employee e3 = new Employee("wangwu", 25);

        RandomAccessFile raf0 = new RandomAccessFile("D:/employee.txt", "rw");
        raf0.writeBytes(e1.getName());
        raf0.writeInt(e1.getAge());
        raf0.writeBytes(e2.getName());
        raf0.writeInt(e2.getAge());
        raf0.writeBytes(e3.getName());
        raf0.writeInt(e3.getAge());
        raf0.close();
    }

    static class Employee {
        private String name;
        private int age;
        private final static int LEN = 8;

        public Employee() {

        }

        public Employee(String name, int age) {
            if (name.length() > LEN) {
                name = name.substring(0, 8);
            } else {
                while (name.length() < LEN) {
                    name = name + "\u0000";
                }
            }
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
