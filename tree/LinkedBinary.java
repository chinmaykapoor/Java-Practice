package BinaryTree;

public class LinkedBinary {
	
	LinkedBinary(int temp)
	{
		node newNode=new node(temp);
		root=newNode;
	}
	LinkedBinary()
	{
		root=null;
	}

	static node root;
	public static class node{
		int data;
		node left,right;
		node(int temp)
		{
			data=temp;
			left=right=null;
		}
	}
	public static void Inorder(node current)
	{
		if(current!=null)
		{	Inorder(current.left);
			System.out.print(current.data+" ");
			Inorder(current.right);
		}return;
		}
	public static void  Preorder(node current)
	{
		if(current!=null)
		{
			System.out.print(current.data+" ");
			Preorder(current.left);
			Preorder(current.right);
		}return;
	}
	public static void Postorder(node current)
	{
		if(current!=null)
		{
			Postorder(current.left);
		  	Postorder(current.right);
			System.out.print(current.data+" ");
		}return;  
	}
	public static void insert()
	{
		node newNd1=new node(20);
		node newNd2=new node(30);
		node newNd3=new node(40);
		node newNd4=new node(50);
		root.left=newNd1;
		root.right=newNd2;
		newNd1.left=newNd3;
		newNd1.right=newNd4;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBinary li=new LinkedBinary();
		LinkedBinary l2=new LinkedBinary(10);
		l2.insert();
		l2.Preorder(root);
		System.out.println(" ");
		l2.Inorder(root);
		System.out.println(" ");
		l2.Postorder(root);
		
		  
	}

}
