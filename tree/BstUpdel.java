package BinaryTree;

import BinaryTree.BST.node;

public class BstUpdel {

	static int flag=0;
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
		searchItem(root,key);
	}
	public static void searchItem(node root,int key)
	{
		if(root==null)
		{
			System.out.println("not found");
			flag=1;
		}
		else if(root.data>key)
		{
			searchItem(root.left,key);
		}
		else if(root.data<key)
		{
			searchItem(root.right,key);
		}
		else if(root.data==key)
		{
			System.out.println("found");
		}
	}
	public static void delete(int key)
	{
		search(key);
		if(flag!=1)
		{
			deleteItem(root,key);
		}
	}
	public static void deleteItem(node root,int key)
	{
		if(root.data==key)
		{
			if(root.left==null && root.right==null)
			{
				flag=2;
			}
			else if(root.left!=null && root.right==null)
			{
				flag=3;
			}
			else if(root.left==null && root.right!=null)
			{
				flag=4;
			}
			else if(root.left!=null && root.right!=null)
			{
				node newNd;
				newNd=root.right;
				while(newNd.left!=null)
				{
					newNd=newNd.left;
				}
				int temp=newNd.data;
				newNd.data=root.data;
				root.data=temp;
				if(root.right.data==temp)
				{
					root.right=null;
				}
				else
				{
					node newNd1;
					newNd1=root.right;
					while(newNd.left.left!=null)
					{
						newNd=newNd.left;
					}
					newNd.left=null;
				}
			}
		}
		else if(root.data>key)
		{
			deleteItem(root.left,key);
			if(flag==2)
			{
				root.left=null;
				flag=0;
			}
			else if(flag==3)
			{
				node newNd;
				newNd=root.left.left;
				root.left=null;
				root.left=newNd;
				flag=0;
			}
			else if(flag==4)
			{
				node newNd;
				newNd=root.left.right;
				root.left=null;
				root.left=newNd;
				flag=0;
			}
		}
		else if(root.data<key)
		{
			deleteItem(root.right,key);
			if(flag==2)
			{
				root.right=null;
				flag=0;
			}
			else if(flag==3)
			{
				node newNd;
				newNd=root.right.left;
				root.right=null;
				root.right=newNd;
				flag=0;
			}
			else if(flag==4)
			{
				node newNd;
				newNd=root.right.right;
				root.right=null;
				root.right=newNd;
				flag=0;
			}
		}
	}
	public static void Inorder(node root)
	{
		if(root!=null)
		{
			Inorder(root.left);
			System.out.print(root.data+" ");
			Inorder(root.right);
		}return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BstUpdel li=new BstUpdel();
		li.insert(50);
		li.insert(30);
		li.insert(70);
		li.insert(35);
		li.insert(25);
		li.insert(20);
		li.insert(28);
		li.insert(8);
		li.insert(65);
		li.insert(100);
		li.insert(29);
		//li.search(108);
		li.delete(30);
		System.out.println("hello");
		li.Inorder(root);
	}

}
