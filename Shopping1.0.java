package bitdemo1;

public class Shopping {
	public static goods creatgood(String name){
		if(name.equals("网球鞋")) {
			return new Qiuxie();
		}else if(name.equals("网球拍")){
			return new Qiupai();
		}else if(name.equals("T恤")){
			return new Tshirt();
		}
		return null;
	}
	
	public static double payMoney(goods[] goods, int discount){
		//计算需要支付的钱
		double money = 0;
		for(int i = 0; i < goods.length; i++) {
			money =money + goods[i].getPrices();
		}
		return money*discount/10;
	}
	
	public static double addIntegral(goods[] goods,int discount,person person) {
		//计算积分
		double money = payMoney(goods, discount);
		person.addIntegral(money*0.08);
		return money*0.01;
	}
	
	public static boolean isPrint(goods[] goods, goods good, int locale) {
		//判断是否有重复的商品
		for(int i = 0; i < locale; i++) {
			if(goods[i].getClass().equals(good.getClass())) {
				return false;
			}
		}
		return true;
	}
	
	public static void printgoodsList(goods[] goods,int discount,person person) {
		//打印清单及详情
		System.out.println("===========商品清单=============\n"+"商品名称"+"\t"+"单价"+"\t"+"数量"+"\t"+"单品总价");
		for(int i = 0; i < goods.length; i++) {
			if(isPrint(goods,goods[i],i)) {
				System.out.println(goods[i].getName()+"\t"+"￥"+goods[i].getPrices()+"\t"
				+goods[i].getcount()+"\t"+"￥"+goods[i].getcount()*goods[i].getPrices());
			}
		}
		System.out.println("===============================");
		double money = payMoney(goods,discount);
		System.out.println("总计："+money*10/discount+"\n"+"折扣："+discount+"\n"+"应付金额:"+money+"\n"
				+"获得积分："+addIntegral(goods, discount, person));
	}
	public static void main(String[] args) {
		person person = new person();
		goods[] goods= new goods[5];
		goods[0] = creatgood("网球拍");
		goods[1] = creatgood("网球鞋");
		goods[2] = creatgood("T恤");
		goods[3] = creatgood("T恤");
		goods[4] = creatgood("网球拍");
		printgoodsList(goods,5,person);
	}

}
class person{
	private static double integral;
	public double getIntegral() {
		return integral;
	}

	public void addIntegral(double d) {
		this.integral = d + this.integral;
	}
}
abstract class goods{
	public abstract int getcount();
	public abstract double getPrices();
	public abstract String getName();

}
class Qiuxie extends goods{
	private  double prices = 570;
	private  String name = "网球鞋";
	private static int count  = 0 ;
	public Qiuxie() {
		count++;
	}
	public double getPrices() {
		return prices;
	}
	public String getName() {
		return name;
	}
	public int getcount() {
		return count;
	}
}
class Tshirt extends goods{
	private double price = 245;
	private String name = "T恤";
	private static int count  = 0 ;
	public int getcount() {
		return count;
	}
	Tshirt() {
		count ++ ;
	}
	public double getPrices() {
		return price;
	}
	public String getName() {
		return name;
	}
}
class Qiupai extends goods{
	private double price = 320;
	private String name = "网球拍";
	private static int count  = 0 ;
	public Qiupai() {
		count++;
	}
	public double getPrices() {
		return price;
	}
	public String getName() {
		return name;
	}
	public int getcount() {
		return count;
	}
}
