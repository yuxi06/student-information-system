package ����;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stud
		Scanner input = new Scanner(System.in);
		ClassNode stu1 = new ClassNode(1, "���Ȼ");
		ClassNode stu2 = new ClassNode(2, "����ǧ��");
		ClassNode stu3 = new ClassNode(3, "����");
		ClassNode stu4 = new ClassNode(4, "����");
		ClassNode stu5 = new ClassNode(5, "������");
		LinkedList list1 = new LinkedList();
		ClassNode head = new ClassNode(0, " ");
		head.next = stu1;
		list1.add(stu1);
		list1.add(stu2);
		list1.add(stu3);
		list1.add(stu4);
		list1.add(stu5);
		boolean flag = true;
		while (flag) {
			System.out.println("1. �鿴ѧ���б�");
			System.out.println("2. ���ѧ��");
			System.out.println("3. �ı�ѧ����Ϣ");
			System.out.println("4. ɾ��ѧ��");
			System.out.println("5. ��Ч�ڵ�");
			System.out.println("6. ���ҵ�����k���ڵ�");
			System.out.println("7. �����ӡ������");
			System.out.println("8. �˳�");
			int n = input.nextInt();
			switch (n) {
			case 1:
				list1.show(head);
				break;
			case 2:
				System.out.println("������ѧ���ı�ţ�");
				int id = input.nextInt();
				System.out.println("������ѧ����������");
				String name = input.next();
				ClassNode classNode = new ClassNode(id, name);
				list1.addByOrder(classNode);
				break;
			case 3:
				System.out.println("������ѧ���ı�ţ�");
				int nid = input.nextInt();
				System.out.println("������ѧ���ĸ��ĺ��������");
				String nname = input.next();
				ClassNode newclassNode = new ClassNode(nid, nname);
				list1.update(newclassNode);
				break;
			case 4:
				System.out.println("������Ҫɾ����ѧ���ı�ţ�");
				int iid = input.nextInt();
				list1.delete(iid);
				break;
			case 5:
				list1.youxiaojiedian(head);
				break;
			case 6:
				int k=input.nextInt();
				list1.findk(k, head);
				break;
			case 7:
				list1.reversetLiset(head);
				list1.show(head);
				break;
			case 8:
				flag = false;
				break;
			default:
				break;
			}
		}
	}
}

class ClassNode {
	public int id;
	public String name;
	public ClassNode next;

	public ClassNode(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return "ID:" + id + "   NAME:" + name;
	}
}

class LinkedList {
	private ClassNode head = new ClassNode(0, " ");

	public void add(ClassNode classNode) {
		ClassNode temp = head;

		boolean flag = true;
		while (flag) {
			if (temp.next == null) {
				flag = false;
				temp.next = classNode;
			}
			temp = temp.next;
		}
	}

	// ������˳���
	public void addByOrder(ClassNode classNode) {
		boolean flag = true;// ����Ƿ����
		ClassNode temp = head;
		while (flag) {
			if (temp.next == null)
				break;
			if (temp.next.id > classNode.id)
				break;// λ���ҵ�
			else if (temp.next.id == classNode.id) {
				flag = false;// ˵����Ŵ���
				break;
			}
			temp = temp.next;
		}
		if (flag == false)
			System.out.println("���û��Ѵ���");
		else {
			classNode.next = temp.next;
			temp.next = classNode;
		}
	}

	public void update(ClassNode newclassNode) {// �޸ĸñ�ŵ���Ϣ
		if (head.next == null)
			System.out.println("������Ϊ��");
		boolean flag = true;// �ж��Ƿ��ҵ��ñ��
		ClassNode temp = head.next;
		while (flag) {
			if (temp.next == null)
				break;
			if (temp.id == newclassNode.id) {
				flag = false;
				break;
			}
			temp = temp.next;
		}
		if (flag == false) {
			temp.id = newclassNode.id;
			temp.name = newclassNode.name;
		} else
			System.out.println("�޴��û�!");
	}

	public void delete(int id) {
		ClassNode temp = head.next;
		boolean flag = true;// �Ƿ��ҵ�Ҫɾ���Ľڵ�
		while (flag) {
			if (temp.next == null)
				break;
			if (temp.next.id == id) {
				flag = false;
				break;
			}
			temp = temp.next;
		}
		if (flag == false) {
			temp.next = temp.next.next;
		} else
			System.out.println("���û�������");
	}

	public void show(ClassNode head) {
		ClassNode temp = head.next;
		boolean flag = true;
		while (flag) {
			if (temp == null) {
				flag = false;
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}

	// ����������Ч�ڵ�ĸ���
	public void youxiaojiedian(ClassNode head) {
		ClassNode temp = head;
		boolean flag = true;
		int sum = 0;
		while (flag) {
			if (temp.next == null)
				flag = false;
			else {
				sum++;
				temp = temp.next;
			}
		}
		System.out.println(sum);
	}

	public int getlength(ClassNode head) {
		ClassNode temp = head;
		int length = 0;
		boolean flag = true;
		while (flag) {
			if (temp.next == null)
				flag=false;
			else {
				length++;
				temp = temp.next;
			}
		}
		return length;
	}

	// ���ҵ������е�����k���ڵ㡾���������⡿
	public void findk(int k, ClassNode head) {
		ClassNode temp = head;
		if (temp.next == null)
			return ;
		int length = getlength(head);
		if (k < 0 || k > length)
			System.out.println("�����ڴ˽ڵ�");
		for (int size = 0; size <= length - k; size++) {
			temp = temp.next;
		}
		System.out.println(temp);
	}

	// ������ת����Ѷ�����⡿
	public void reversetLiset(ClassNode head) {
		if(head.next==null || head.next.next==null)
		{
			return ;
		}
		ClassNode cur=head.next;
		ClassNode next=null;
		ClassNode newhead=new ClassNode(0,"");
		while(cur!=null)
		{
			next=cur.next;
			cur.next=newhead.next;
			newhead.next=cur;
			cur=next;
		}
		head.next=newhead.next;
	}
}
