package BinaryTree;
import java.util.Scanner;
public class BSTall {
	public static node root;
	public static class node
	{
		int data;
		node left;
		node right;
		node(int d)
		{
			data=d;
			left=right=null;
		}
	}
	public static  void insert(int temp)
	{
		root=insertItem(root,temp);
	}
	public static node insertItem(node root,int temp)
	{
		if(root==null)
		{
			root=new node(temp);
			return root;
		}
		else if(root.data<temp)
		{
			root.right=insertItem(root.right, temp);
		}
		else if(root.data>temp)
		{
			root.left=insertItem(root.left, temp);
		}
		return root;
		
	}
	public static void inorder(node root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	public  int height()
	{
		int h=heightitem(root);
		//System.out.println(h);
		return h;
	}
	public int heightitem(node root)
	{int c=0;
	int c1=0;
		if(root==null)
		{
			return -1;
		}
		else if(root!=null) {
		c=heightitem(root.left);
		c++;
		c1=heightitem(root.right);
		c1++;
		}
		if(c>c1)
			return c;
		else
			return c1;
	}
public void printlev()
{
	int h=height();
	System.out.println();
	for(int i=1;i<=h+1 ;i++)
	{
		printlevel(root,i);
		System.out.println();
	}
}
public static void printlevel(node root,int ind)
{
	if(root==null)
	{
		return;
	}
	else if(ind==1)
	{
		System.out.print(root.data+" ");
	}
	else if(ind>1)
	{
		printlevel(root.left, ind-1);
		printlevel(root.right,ind-1);
	}
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		BSTall li=new BSTall();
		System.out.println("enter size");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			li.insert(sc.nextInt());
		}
		li.inorder(root);
		li.height();
		li.printlev();
	}

}
