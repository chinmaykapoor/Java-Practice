package BinaryTree;

import BinaryTree.LinkedBinary.node;

public class BST {

	static node root;
	 node root1;
	public static class node{
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
	public static void search(int key)
	{
		root=SearchItem(root,key);
	}
	public static node SearchItem(node root,int input)
	{
		if(root==null)
		{
			System.out.println("not found");
		}
		else if(root.data<input)
		{
			root.right=SearchItem(root.right,input);
		}
		else if(root.data>input)
		{
			root.left=SearchItem(root.left,input);
		}
		else if(root.data==input)
		{
			System.out.println("found");
		}return root;
	}
	public static void height()
	{int x=0;
		x=height(root);
		System.out.println(" ");
		System.out.print("height: ");
		System.out.print(x);
	}
	public static int height(node root)
	{
		
		int c=0,c1=0;
		if(root==null)
		{
		return -1;
		}
		if(root!=null)
		{
			c=height(root.left);
			c++;
			c1=height(root.right);
			c1++;
		}
		if(c>c1)
			  return c;
		  else
		return c1;
		 
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
		BST li=new BST();
		root=new node(50);

		li.insert(30);
		li.insert(70);
		li.insert(10);
		li.insert(40);
		li.insert(60);
		li.insert(80);
		li.insert(5);
		li.insert(55);
		li.insert(52);
		li.Inorder(root);
		//li.search(700);
		li.height();
		

	}

}
