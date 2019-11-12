package BinaryTree;

import java.util.ArrayList;

import BinaryTree.BSTT.node;
import java.util.Scanner;

public class BSTTS {
	static node root;
	public static class node
	{
		int data;
		node left,right;
		node(int temp)
		{
			data=temp;
			left=right=null;
		}
	}
	public static void insert(int key)
	{
		root=insertItem(root,key);
	}
	public static node insertItem(node root,int temp)
	{
		if(root==null)
		{
			root=new node(temp);
			return root;
		}	
		else if(temp<root.data)
			{
				root.left=insertItem(root.left,temp);
		
			}
			else if(root.data<temp)
			{
			root.right=insertItem(root.right,temp);
			}
		return root;
	}
	public static void Inorder(node current)
	{
		if(current!=null)
		{	Inorder(current.left);
			System.out.print(current.data+" ");
			Inorder(current.right);
		}return;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTTS li=new BSTTS();
		ArrayList li1=new ArrayList();
		Scanner sc=new Scanner(System.in);
		int count=0;
		String str;
		do {
			int n=sc.nextInt();
			//li1.add(n);
			li.insert(n);
			System.out.println("press Y if you want to continue");
			str=sc.next();
		}while(str.equals("y")||str.equals("Y"));
		//int n=li1.size();
		//int a=li1.get(n);
		
		//li.insert();
		
		
	}

}
