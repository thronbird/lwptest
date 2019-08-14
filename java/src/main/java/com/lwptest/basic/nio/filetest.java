package com.lwptest.basic.nio;


import java.io.File;

public class filetest {

	public static void main(String[] args) {
		String fileName = "D:" + File.separator + "book";
		File file = new File(fileName);

		if (file.exists() && file.isDirectory()) // �ж�·��ָ����ļ�/�ļ����Ƿ���ڡ��Ƿ�Ŀ¼
		{

           System.out.println("file��һ���ļ���\n");

			File[] files = file.listFiles(); // ��ȡĿ¼�µ������ļ�/�ļ��У����ò�·���£�
			System.out.print("·�������ļ���");
			for (File f : files) {
				System.out.print(f + "\t");
			}
			System.out.println();

			System.out.println("files[0]���ļ�����" + files[0].getName()); // ��ȡ�ļ������ļ�����
			System.out.println("files[0]���ļ�·����" + files[0].getPath()); // ��ȡ�ļ����ļ���·��
 			System.out.println("files[0]�ľ���·����" + files[0].getAbsolutePath()); // ��ȡ�ļ����ļ��о���·��
			System.out.println("files[0]�ĸ��ļ�������" + files[0].getParent()); // ��ȡ�ļ���Ŀ¼·��
			System.out.println(files[0].exists() ? "files[0]�Ĵ���" : "files[0]�Ĳ�����"); // �ж��ļ����ļ����Ƿ����
			System.out.println(files[0].canWrite() ? "files[0]�Ŀ�д" : "files[0]�Ĳ���д"); // �ж��ļ��Ƿ��д
			System.out.println(files[0].canRead() ? "files[0]�Ŀɶ�" : "files[0]�Ĳ��ɶ�"); // �ж��ļ��Ƿ�ɶ�
			//System.out.println(files[0].canExecute() ? "file[0]��ִ��" : "file[0]����ִ��"); // �ж��ļ��Ƿ��ִ��
			System.out.println(files[0].isDirectory() ? "files[0]����Ŀ¼" : "files[0]�Ĳ���Ŀ¼"); // �ж��ļ����ļ����ǲ���Ŀ¼
			System.out.println(files[0].isFile() ? "files[0]�����ļ�" : "files[0]�Ĳ����ļ�"); // �ж����ļ����ļ����ǲ��Ǳ�׼�ļ�
			System.out.println(files[0].isAbsolute() ? "files[0]��·�����Ǿ���·��" : "files[0]��·�������Ǿ���·��"); // �ж�·�����ǲ��Ǿ���·��
			System.out.println("files[0]������޸�ʱ�䣺" + files[0].lastModified()); // ��ȡ�ļ����ļ�����һ���޸�ʱ��
			System.out.println("files[0]�Ĵ�С��" + files[0].length() + " Bytes"); // ��ȡ�ļ����ֽ����������һ���ļ��������ֵΪ0
			System.out.println("files[0]��·��ת��ΪURI��" + files[0].toURI()); // ��ȡ�ļ�·��URI���·����

			if (files[0].exists())
				files[0].delete(); // ɾ��ָ�����ļ����ļ���
			if (files[1].exists())
				files[1].deleteOnExit(); // ���������ֹʱɾ��ָ�����ļ����ļ���
		}
	}
}
