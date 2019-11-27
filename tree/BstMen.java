package BinaryTree;
import java.util.Scanner;

import BinaryTree.BST.node;

public class BstMen {
	static int flag=0;
	static node newNd1;
	static node newNd2;
	static node newNd11;
	static node newNd12;
	static node newNd3;
	static node newNd112;
	static node newNd22;
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
	public static void Inorder(node current)
	{
		if(current!=null)
		{	Inorder(current.left);
			System.out.print(current.data+" ");
			Inorder(current.right);
		}return;
	}
	public static void Preorder(node current)
	{
		if(current!=null)
		{
			System.out.println(current.data);
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
			System.out.println(current.data);
		}return;
	}
	
	public static void delete(int key)
	{
		search(key);
		if(flag==0)
		{
			deleteItem(root,key);
		}
	}
	public static void deleteItem(node root,int key)
	{
		if(root.data>key)
		{
			flag=1;
			deleteItem(root.left,key);
			if(flag==2)
			{
				root.left=null;
				flag=1;
			}
			else if(flag==3)
			{
				root.left=null;
				root.left=newNd1;
				flag=1;
			}
			else if(flag==4)
			{
				root.left=null;
				root.left=newNd2;
				flag=1;
			}
			else if(flag==5)
			{
				root.left=null;
				root.left=newNd12;
				flag=1;
			}
		}
		else if(root.data<key)
		{
			flag=1;
			deleteItem(root.right,key);
			if(flag==2)
			{
				root.right=null;
				flag=1;
			}
			else if(flag==3)
			{
				root.right=null;
				root.right=newNd1;
				flag=1;
			}
			else if(flag==4)
			{
				root.right=null;
				root.right=newNd2;
				flag=1;
			}
			else if(flag==5)
			{
				root.right=null;
				root.right=newNd12;
				flag=1;
			}
		}
		else if(root.data==key)
		{
			if(root.left==null && root.right==null)
			{
				//node Nd=root;
				//Nd=null;
				//System.out.println("item deleted");
				flag=2;
			}
			else if(root.left!=null && root.right==null)
			{
				flag=3;
				newNd1=root.left;
			}
			else if(root.left==null && root.right!=null)
			{
				flag=4;
				newNd2=root.right;
			}
			else if(root.left!=null && root.right!=null && flag==1)
			{
				newNd11=root.left;
				newNd12=root.right;
				while(newNd12.left!=null)
				{
					newNd12=newNd12.left;
				}
				newNd12.left=newNd11;
				newNd12=root.right;
				newNd3=root.right;
				root.left=null;
				newNd3=null;
				root=null;
				root=newNd12;
	
				flag=5;
			}
			else if(root.left!=null && root.right!=null && flag==0 )
			{
				newNd22=root.right;
				int temp=root.data;
				while(newNd22.left!=null)
				{
					newNd22=newNd22.left;
				}
				
				root.data=newNd22.data;
				newNd22.data=temp;
				if(root.right.data==temp)
				{
					root.right=null;
				}
				else if(root.right.left.data==temp)
				{
					root.right.left=null;
				}
				else 
				{
					node newNd=root.right;
					while(newNd.left.left!=null)
					{
						newNd=newNd.left;
					}
					newNd.left=null;
				}
				
			}
		}
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BstMen li=new BstMen();
		Scanner sc=new Scanner(System.in);
		String str,str1;
		do {
			System.out.println("1. Insert in Bst ");
			System.out.println("2. Display Bst");
			System.out.println("3. Delete in Bst");
			System.out.println("Please press the selected option: ");
			int a=sc.nextInt();
			switch (a)
			{
				case 1:
				{
					do {
					System.out.println("Enter the element you want to insert in BST");
					int b=sc.nextInt();
					li.insert(b);
					System.out.println("Press Y if you want to insert more element otherwise press any other key");
					str=sc.next();
					
					}while(str.equals("Y")|| str.equals("y"));
				break;
				}
				case 2:
				{
					System.out.println("1. Inorder display");
					System.out.println("2. Preorder display");
					System.out.println("3. Postorder display");
					System.out.println("Press the selected option");
					int c=sc.nextInt();
					switch (c)
					{
						case 1:
						{
							if(root==null)
							{
								System.out.println("Bst is empty");
							}
							else
							li.Inorder(root);
							break;
						}
						case 2:
						{
							if(root==null)
							{
								System.out.println("Bst is empty");
							}
							else
							li.Preorder(root);
							break;
						}
						case 3:
						{
							if(root==null)
							{
								System.out.println("Bst is empty");
							}
							else
							li.Postorder(root);
							break;
						}
						default:
						{
							System.out.println("you press the wrong key");
							break;
						}
					}
				break;
				}
				case 3:
				{
					System.out.println("Enter the element you want to delete from Bst");
					int d=sc.nextInt();
					li.delete(d);
					break;
				}
				default:
				{
					System.out.println("Oops! you pressed the wrong key ");
					break;
				}
			}
			System.out.println("Press Y if want to continue");
			str1=sc.next();
		}while(str1.equals("Y")|| str1.equals("y"));
	}
 
}