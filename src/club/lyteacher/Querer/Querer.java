package club.lyteacher.Querer;

import java.util.Scanner;

public class Querer {
	public static void main(String[] args) {
		ArrayQuerer querer = new ArrayQuerer(3);
		boolean loop = true;
		char input = ' ';
		Scanner scanner = new Scanner(System.in);
		while (loop) {
			System.out.printf("s(show): ��ʾ����\t");
			System.out.printf("e(exit): �˳�����\t");
			System.out.printf("a(add): ������ݵ�����\t");
			System.out.printf("g(get): �Ӷ���ȡ������\t");
			System.out.printf("h(head): �鿴����ͷ������\t");
			input = scanner.next().charAt(0);// ����һ���ַ�
			switch (input) {
			case 's':
				try {
					querer.showAll();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'a':
				System.out.println("���һ����");
				int value = scanner.nextInt();
				try {
					querer.add(value);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'g': // ȡ������
				try {
					int res = querer.get();
					System.out.printf("ȡ����������%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h': // �鿴����ͷ������
				try {
					int res = querer.showFirst();
					System.out.printf("����ͷ��������%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e': // �˳�
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
	}
}

class ArrayQuerer {
	int maxSize;
	int first;
	int end;
	int[] arr;

	public ArrayQuerer(int size) {
		maxSize=size;
		first=0;
		end=0;
		arr = new int[maxSize];
	}

	public boolean isEmpty() {
		return first == end;
	}

	public boolean isFull() {
		return end == maxSize;
	}

	public void add(int val) {
		if (isFull()) {
			System.out.println("�����������޷��������");
			return;
		}
		arr[end++] = val;
	}

	public int get() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ��޷�ȡ������");
		}
		return arr[first++];
	}

	public void showAll() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ��޷�ȡ������");
		}
		for (int i = first; i < end; i++) {
			System.out.println(arr[i]);
		}
	}

	public int showFirst() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ��޷�ȡ������");
		}
		return arr[first];
	}
}
