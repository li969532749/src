package gongSiGuYuan;

public class Gongsi {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
      Employee[] e=new Employee[5];
      e[0]=new Employee("赵君",2); 
      e[1]=new SalariedEmployee("宋婕", 1, 8000);
      e[2]=new HourlyEmployee("王超", 5, 10, 300);
      e[3]=new SalesEmployee("秋娥", 2, 200000, 0.05);
      e[4]=new BasePlusSalesEmployee("郭镫鸿", 1, 1000000, 0.1, 10000);
      int month=2;
      System.out.println("宇宙集团"+month+"月工资表");
      for(int i=0;i<=4;i++) {
    	  System.out.println(e[i].getName()+": "+e[i].getSalary(month));
      }
	}
}
class Employee{
	private String name;
	private int birth;
	
    public String getName() {
		return name;
	}

	public Employee(String name,int birth) {
		this.name = name;
		this.birth=birth;
	}
		public double getSalary(int month) {
		if (month==birth) {
			return 100;
		}
		return 0;
	}
}
class SalariedEmployee extends Employee{
	private double salary;
	public SalariedEmployee(String name,int birth,double salary) {
		super(name,birth);
		this.salary=salary;
	}
	public double getSalary(int month) {
		return salary+super.getSalary(month);
	}
}
class HourlyEmployee extends Employee{
	private double hourSalary;
	private int hour;
	public HourlyEmployee(String name,int birth,int hour,double hourSalary) {
		super(name,birth);
		this.hour=hour;
		this.hourSalary=hourSalary;
	}
	public double getSalary(int month) {
		if (hour>160) {
			return hourSalary*160+hourSalary*1.5*(hour-160)+super.getSalary(month);
		}else {
		return hourSalary*hour+super.getSalary(month);
		}
	}
}
class SalesEmployee extends Employee{
	private double sales;
	private double pre;
	public SalesEmployee(String name,int birth,double sales,double pre ) {
		super(name,birth);
		this.sales=sales;
		this.pre=pre;
	}
	public double getSalary(int month) {
		return sales*pre+super.getSalary(month);
	}
}
class BasePlusSalesEmployee extends SalesEmployee{
	private double baseSalary;
	public BasePlusSalesEmployee(String name,int birth,double sales,double pre,double baseSalary) {
		super(name,birth,sales,pre);
		this.baseSalary=baseSalary;
		}
	public double getSalary(int month) {
		return baseSalary+super.getSalary(month);
	}
}


