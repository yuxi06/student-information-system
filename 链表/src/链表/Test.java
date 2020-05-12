package 链表;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stud
		Scanner input = new Scanner(System.in);
		ClassNode stu1 = new ClassNode(1, "刘昊然");
		ClassNode stu2 = new ClassNode(2, "易烊千玺");
		ClassNode stu3 = new ClassNode(3, "胡歌");
		ClassNode stu4 = new ClassNode(4, "吴磊");
		ClassNode stu5 = new ClassNode(5, "彭于晏");
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
			System.out.println("1. 查看学生列表");
			System.out.println("2. 添加学生");
			System.out.println("3. 改变学生信息");
			System.out.println("4. 删除学生");
			System.out.println("5. 有效节点");
			System.out.println("6. 查找倒数第k个节点");
			System.out.println("7. 反向打印单链表");
			System.out.println("8. 退出");
			int n = input.nextInt();
			switch (n) {
			case 1:
				list1.show(head);
				break;
			case 2:
				System.out.println("请输入学生的编号：");
				int id = input.nextInt();
				System.out.println("请输入学生的姓名：");
				String name = input.next();
				ClassNode classNode = new ClassNode(id, name);
				list1.addByOrder(classNode);
				break;
			case 3:
				System.out.println("请输入学生的编号：");
				int nid = input.nextInt();
				System.out.println("请输入学生的更改后的姓名：");
				String nname = input.next();
				ClassNode newclassNode = new ClassNode(nid, nname);
				list1.update(newclassNode);
				break;
			case 4:
				System.out.println("请输入要删除的学生的编号：");
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

	// 增加有顺序的
	public void addByOrder(ClassNode classNode) {
		boolean flag = true;// 编号是否存在
		ClassNode temp = head;
		while (flag) {
			if (temp.next == null)
				break;
			if (temp.next.id > classNode.id)
				break;// 位置找到
			else if (temp.next.id == classNode.id) {
				flag = false;// 说明编号存在
				break;
			}
			temp = temp.next;
		}
		if (flag == false)
			System.out.println("该用户已存在");
		else {
			classNode.next = temp.next;
			temp.next = classNode;
		}
	}

	public void update(ClassNode newclassNode) {// 修改该编号的信息
		if (head.next == null)
			System.out.println("此链表为空");
		boolean flag = true;// 判断是否找到该编号
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
			System.out.println("无此用户!");
	}

	public void delete(int id) {
		ClassNode temp = head.next;
		boolean flag = true;// 是否找到要删除的节点
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
			System.out.println("此用户不存在");
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

	// 求单链表中有效节点的个数
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

	// 查找单链表中倒数第k个节点【新浪面试题】
	public void findk(int k, ClassNode head) {
		ClassNode temp = head;
		if (temp.next == null)
			return ;
		int length = getlength(head);
		if (k < 0 || k > length)
			System.out.println("不存在此节点");
		for (int size = 0; size <= length - k; size++) {
			temp = temp.next;
		}
		System.out.println(temp);
	}

	// 单链表反转【腾讯面试题】
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
