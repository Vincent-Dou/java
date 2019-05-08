
public class Shopping {
	public static goods creatgood(String name) {
		if(name.equals("网球鞋")) {
			return new Qiuxie();
		}else if(name.equals("网球拍")) {
			return new Qiupai();
		}else if(name.equals("T恤")){
			return new Tshirt();
		}
		return null;
	}
	public static double payMoney(goods[] goods){
		//计算需要支付的钱
		double money = 0;
		for(int i = 0; i < goods.length; i++) {
			money =money + goods[i].getPrices();
		}
		return money;
	}
	
	public static double payMoney(goods[] goods, int discount){
		//在有折扣的情况下计算需要支付的钱
		double money = 0;
		for(int i = 0; i < goods.length; i++) {
			money =money + goods[i].getPrices();
		}
		return money*discount/10;
	}
	
	public static void printgoodsList(goods[] goods) {
		for(int i = 0; i < goods.length; i++) {
			System.out.println(goods[i].getName()+"\t"+"$"+goods[i].getPrices()+"\t");
		}
	}
	public static void main(String[] args) {
		goods[] goods= new goods[4];
		goods[0] = creatgood("网球拍");
		goods[1] = creatgood("网球鞋");
		goods[2] = creatgood("T恤");
		goods[3] = creatgood("T恤");
		printgoodsList(goods);
		System.out.println("====================");
		System.out.println("总计："+"\t"+payMoney(goods)+"\n"+"折扣：\t8 \n应付总额：\t"+payMoney(goods,8));
	}

}
abstract class goods{
	
	public abstract double getPrices();
	public abstract String getName();

}
class Qiuxie extends goods{
	private  double prices = 570;
	private  String name = "网球鞋";
	public double getPrices() {
		return prices;
	}
	public String getName() {
		return name;
	}
}
class Tshirt extends goods{
	private double price = 245;
	private String name = "T恤";
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
	public double getPrices() {
		return price;
	}
	public String getName() {
		return name;
	}
}
