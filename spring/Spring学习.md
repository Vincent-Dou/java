====================================================================
0612：

spring的依赖注入
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="student" class="test.student">
        <property name="name" value="douguangyao"/>
        <property name="age" value="20"/>
    </bean>
</beans>
```
spring的对象获取
```
    public void test1(){
        ApplicationContext acx = new ClassPathXmlApplicationContext("spring.xml");
        student student = (test.student) acx.getBean("student");
        System.out.println(student);
    }
```
加载spring容器的三种方法：
```
1. 类路径获得配置文件：
    public void test1(){
        ApplicationContext acx = new ClassPathXmlApplicationContext("spring.xml");
        student student = (test.student) acx.getBean("student");
        System.out.println(student);
    }
2. 文件系统路径获得配置文件
    public void test2(){
        ApplicationContext acx = new FileSystemXmlApplicationContext("D:\\workplace\\ideaworkplace\\springStudy\\src\\main\\resources\\spring.xml");
        student student = (test.student) acx.getBean("student");
        System.out.println(student);
    }
3. 使用BeanFactory
    public void test3(){
        BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("D:\\workplace\\ideaworkplace\\springStudy\\src\\main\\resources\\spring.xml"));
        student student = (test.student) beanFactory.getBean("student");
        System.out.println(student);
    }
```
BeanFactory  采用延迟加载， 在第一次getBean时才会初始化Bean
ApplicationContext  及时加载，在加载容器时就初始化Bean

==================================================================================================================================================
0621：
**装配Bean的三种方式**
1. 采用默认构造函数，在spring的配置文件中使用bean标签， 配以id和属性class之后，且没有其他属性和标签时，采用的就是默认构造函数创建bean对象，
	此时如果类中没有默认构造函数，则对象无法创建
```
<bean id="user" class="dgy.bean.User"></bean>
```
2. 使用某个类中的方法创建对象，并存入spring容器中
```
    <bean id="Factory" class="dgy.bean.UserFactory"></bean>
    <bean id="user" factory-bean="Factory" factory-method="getUser"></bean>
	注意：工厂中的方法是未被static修饰的
```
3. 使用某个工厂中的静态方法创建对象，并存入对象中
```
<bean id="usu" class="dgy.bean.UserFactory" factory-method="getUser"></bean>
```

**bean的作用范围调整**
	bean标签的scope属性，作用：用于指定bean的作用范围
	取值：
	①：singleton： 单例的（默认）
	②：prototype： 多例的
	③：request：   作用于web应用的请求范围
	④：session：	   作用于web应用的会话范围
	⑤：global-session： 作用于集群环境的会话范围（全局会话范围），若不是集群环境他就是session

**bean对象的生命周期**
单例对象：
	出生：当容器创建时对象出生
	活着：只要容器还在，对象就只要活着
	死亡：容器销毁，对象消亡
	总结：单例对象的生命周期和容器相同
多例对象：
	出生：但我们使用多例对象时，spring为我们创建对象
	活着：对象只要是在使用过程中就一直活着
	死亡：当对象长时间不用，且没有别的对象引用时，有java垃圾回收器回收

**依赖注入**
依赖关系的管理：以后都交给spring来维护，在当前类需要用到其他类的对象时，有spring为我们提供，我们只需要在配置文件中
			   说明依赖关系的维护。就称之为依赖的注入
依赖注入的数据类型:
		基本类型和String
		其他bean类型（在配置文件或者注解配置过的bean）
		复杂类型（集合类型）
**注入的方式：**
		①：使用构造函数提供
		②：使用set方法提供
		③：使用注解提供
①构造函数注入（无get/set方法)：
		使用的标签constructor-arg
		标签出现的位置：bean标签内部
		标签中的属性
			type：用于指定要注入的数据类型，该数据类型也是构造函数中某个或某些参数的类型
			index：用于指定要注入的数据在构造函数中指定索引位置的参数赋值，从0开始
			name：用于指定给构造函数中指定名称的参数赋值
			value: 用于提供基本类型和String类型的数据
			ref： 用于指定其他的bean类型数据，它指的就是在spring的IOC核心容器中出现的bean对象
		**优势**：在获取对象时，注入数据是必须的操作，否则无法创建成功
		**弊端**：改变了bean对象的实例化方式，使我们在创建对象时，如果用不到这些数据，也必须提供
```
    <bean id="person" class="dgy.bean.Person">
        <constructor-arg name="name" value="dou"></constructor-arg>
        <constructor-arg name="age" value="20"></constructor-arg>     //<constructor-arg index="1" value="20"></constructor-arg>
        <constructor-arg name="birthday" ref="date"></constructor-arg>
    </bean>
    <bean id="date" class="java.util.Date"></bean>
```
②set方法注入(常用方式)
		涉及的标签：property
		出现的位置：bean标签的内部
		标签的属性：
			name：用于指定注入时所调用的set方法名称
			value：用于指定提供基本数据类型和String的数据
			ref： 用于指定其他的bean类型数据，指的是在spring的IOC容器中出现的bean对象
		优势：创建对象时没有明确的限制，可以直接使用默认构造函数
		弊端：如果有某个成员必须有值，则获取对象时有可能set方法没有执行
```
    <bean id="person" class="dgy.bean.Person">
        <property name="age" value="51"></property>
        <property name="name" value="douguang"></property>
        <property name="birthday" ref="birthday"></property>
    </bean>
    <bean id="birthday" class="java.util.Date"></bean>
```

**集合数据类型的注入**
	①：用于给List结构集合注入的标签：list、array、set
	②：用于Map结构集合注入的标签： map、props
	注意： 结构相同，标签可以互换
```
    <bean id="jcf" class="dgy.bean.JCFtest">
        <property name="myStrs">
            <array>
                <value>AAA</value>
                <value>BBB</value>
                <value>CCC</value>
            </array>
        </property>
        <property name="myList">
            <list>
                <value>GGG</value>
                <value>JJJ</value>
                <value>FFF</value>
            </list>
        </property>
        <property name="myMap">
            <map>
                <entry key="444" value="DDD"></entry>
                <entry key="555" value="EEE"></entry>
            </map>
        </property>
        <property name="myProperties">
            <props>
                <prop key="1">pr1</prop>
                <prop key="2">pr2</prop>
                <prop key="3">pr3</prop>
            </props>
        </property>
    </bean>
```
