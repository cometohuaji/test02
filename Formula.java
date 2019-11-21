package hello;

import java.util.Random;

public class Formula {
	int Max = 100,Min = 0;
	int left,right,ans = 0;
	char sign = '+';
	
	//构造算式
	void create(int f_Left,int f_Right,char f_Sign) {
		left = f_Left;
		right = f_Right;
		if(f_Sign == '-') {
			ans = left - right;
			sign = '-';
		}
		else {
			ans = left + right;
		}
	}
	//产生加法算式
	Formula create_Add() {
		Random rand = new Random();
		int f_Left,f_Right,f_Ans;
		f_Left = rand.nextInt(Max+1);
		f_Right = rand.nextInt(Max+1);
		f_Ans = f_Left + f_Right;
		while(f_Ans > Max) {
			f_Left = rand.nextInt(Max+1);
			f_Right = rand.nextInt(Max+1);
			f_Ans = f_Left + f_Right;
		}
		Formula now = new Formula();
		now.create(f_Left, f_Right, '+');
		return now;
	}
	//产生减法算式
	Formula create_Minus() {
		Random rand = new Random();
		int f_Left,f_Right,f_Ans;
		f_Left = rand.nextInt(Max+1);
		f_Right = rand.nextInt(Max+1);
		f_Ans = f_Left - f_Right;
		while(f_Ans < Min) {
			f_Left = rand.nextInt(Max+1);
			f_Right = rand.nextInt(Max+1);
			f_Ans = f_Left - f_Right;
		}
		Formula now = new Formula();
		now.create(f_Left, f_Right, '-');
		return now;
	}
	//产生算式
	Formula create_Formula() {
		Random rand = new Random();
		int now_Sign ;
		now_Sign = rand.nextInt(2);
		if(now_Sign == 0)return create_Minus();
		else return create_Add();
	}
	//相同判断
	boolean equals(Formula test) {
		if(test.sign == sign) {
			return test.left == left && test.right == right ;
		}
		else return false;
	}
}
