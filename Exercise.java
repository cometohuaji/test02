package hello;

public class Exercise {
	int formula_Max = 50;
	Formula formula_List[] = new Formula[formula_Max+1];
	//产生习题
	void create_Exercise() {
		Formula now_Formula01 ,now_Formula02 = new Formula();
		for(int i = 1; i <= formula_Max ; i++) {
			now_Formula01 = now_Formula02.create_Formula();
			while(check(now_Formula01,i) == false) {
				now_Formula01 = now_Formula02.create_Formula();
			}
			formula_List[i] = now_Formula01;
		}
	}
	//检测是否重复
	boolean check(Formula now_Formula, int len) {
		for(int i = 1; i < len; i++) {
			if(now_Formula.equals(formula_List[i]) == true) {
				return false ;
			}
		}
		return true ;
	}
	//输出 按照一行num个元素输出
	void formula_Print(int num) {
		int now = 1, i = 1;
		while(i <= formula_Max) {
			System.out.printf("%3d %c %3d = ? ",formula_List[i].left,formula_List[i].sign,formula_List[i].right);
			if(now == 0){
				System.out.println("");
				now = 1;
			}
			else now++;
			now = now % num;
			i++;
		}
	}
	//输出答案 按每行num个元素输出
	void answer_Print(int num) {
		int now = 1, i = 1;
		while(i <= formula_Max) {
			System.out.printf("%3d %c %3d = %3d ",formula_List[i].left,formula_List[i].sign,formula_List[i].right,formula_List[i].ans);
			if(now == 0){
				System.out.println("");
				now = 1;
			}
			else now++;
			now = now % num;
			i++;
		}
	}
}
