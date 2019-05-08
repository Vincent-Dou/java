package bitdemo1;

//Copyright(C) 2000-2003 Yoshinori Oota All rights reserved.

public class FactoryMethodSample
{
 static public Creator Create(String str)
 {
     if (str.equals("A"))
     {
         return new CreatorA();
     }
     else if (str.equals("B"))
     {
         return new CreatorB();
     }
     return null;
 }

 static public void main(String[] args)
 {
     Creator creator1 = Create("A"); // ¥¯¥é¥¤¥¢¥ó¥È¥³©`¥É¤Ï¡¢ConcreteCreator¤¬¡¢
     Creator creator2 = Create("B"); // £Á¤«£Â¤«¡¢Òâ×R¤¹¤ë±ØÒª¤Ï¤Ê¤¤

     Product product1 = creator1.FactoryMethod();
     Product product2 = creator2.FactoryMethod();

     product1.Operation();
     product2.Operation();
 }
}

//abstract class to be implemented by CreatorA and CreatorB
abstract class Creator
{
	// only method to be implemented by subclass
 abstract public Product FactoryMethod();
}

class CreatorA extends Creator
{
 public Product FactoryMethod()
 {
     return new ProductA();  // an instance of ProductA is created
 }
}

class CreatorB extends Creator
{
 public Product FactoryMethod()
 {
     return new ProductB();  // an instance of ProductB is created
 }
}

abstract class Product
{
 abstract void Operation();
}

class ProductA extends Product
{
 public void Operation()
 {
     System.out.println("ProductA");
 }
}

class ProductB extends Product
{
 public void Operation()
 {
     System.out.println("ProductB");
 }
}
