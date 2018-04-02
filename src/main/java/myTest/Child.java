package myTest;

/**
 * Created by Stephen Cai on 2017-07-05 10:36.
 */
class Parent{
	static String name = "hello";
	{
		System.out.println("parent block");
	}
	static {
		System.out.println("parent static block");
	}
	public Parent(){
		System.out.println("parent constructor");
	}
}

public class Child extends Parent{
	static String childName = "hello";
	{
		System.out.println("child block");
	}
	static {
		System.out.println("child static block");
	}
	public Child(){
		System.out.println("child constructor");
	}
}

