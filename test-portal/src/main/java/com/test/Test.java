package com.test;

public class Test {
		public void gogo(){
			HelloParent hp = new HelloParent();
			hp.print("测试一下，这个子类");
		}
		public static void main(String[] args) {
			Test test = new Test();
			test.gogo();
		}
}
