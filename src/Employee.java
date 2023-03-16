public class Employee {

   String name;  //Çalışanın adı ve soyadı
    double salary ;//Çalışanın maaşı

     double adjSalary;
   int  workHours; // Haftalık çalışma saati
    int hireYear; //İşe başlangıç yılı

    static int currentYear=2021;

    Employee(String name,int salary,int workHours,int hireYear){
       this.name=name;
       this.salary=salary;
       this.hireYear=hireYear;
       this.workHours=workHours;
       this.adjSalary=this.salary;
        System.out.println(this);
        bonus();
        tax();
        raiseSalary();

    }

    void tax(){
        if(isTaxable()){
            double tax=this.salary *0.03;
            System.out.println( "Tax = - "+tax);
            this.adjSalary-=tax;

        }
    }

    void bonus(){
        if(isBonus()){
            int bonus=(workHours-40)*30;
            System.out.println("Bonus ="+bonus);
            this.adjSalary+=bonus;
        }
    }

    void raiseSalary(){
        double raise=0;
        if(currentYear-hireYear<10){
            raise= this.salary*(0.05);
            this.adjSalary+=raise;
        }else if(currentYear-hireYear>9 && currentYear-hireYear<20){
            raise= this.salary*(0.1);
            this.adjSalary+=raise;
        }else if(currentYear-hireYear>19){
            raise= this.salary*(0.15);
            this.adjSalary+=raise;
        }

        System.out.println("Raise = "+raise);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getSalary() {
        System.out.println("unadjusted salary =>"+ this.salary);

        System.out.println("adjusted salary =>"+this.adjSalary);

    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public int getHireYear() {
        return hireYear;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }

    public static int getCurrentYear() {
        return currentYear;
    }

    public static void setCurrentYear(int currentYear) {
        Employee.currentYear = currentYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", workHours=" + workHours +
                ", hireYear=" + hireYear +
                '}';
    }

    boolean isTaxable(){
        return salary > 1000;
    }

    boolean isBonus(){
        return workHours > 40;
    }
}
