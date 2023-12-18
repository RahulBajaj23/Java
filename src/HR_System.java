import java.util.HashMap;
import java.util.Map;

class Employee{
    String firstName;
    String lastName;
    int registration;
    int age;
    int daysWorked;
    int vaccationDaysTaken;
    double salary;
    int yearsWorked;

    public Employee(String firstName,String lastName,int registration,int age,int daysWorked,int vaccationDaysTaken,double salary,int yearsWorked){
        this.firstName=firstName;
        this.lastName=lastName;
        this.registration=registration;
        this.age=age;
        this.daysWorked=daysWorked;
        this.vaccationDaysTaken=vaccationDaysTaken;
        this.salary=salary;
        this.yearsWorked=yearsWorked;
    }
    public int timeToRetirement(){
        // time to retirement = min(60 - age, 40 - yearsWorked)
        return Math.min(60-age,40-yearsWorked);
    }

    public int vacationTimeLeft(){
        // vacation time left = (daysWorked/360)*(30 - vacationDaysTaken)
        return (int) ((daysWorked/360.0)*(30-vaccationDaysTaken));

    }

    public int calculateBonus(){
        // bonus = 2.2*salary
        return (int) (2.2*salary);
    }
}
class salesRep extends Employee{
    double salesMade;

    public salesRep(String firstName,String lastName,int registration,int age,int daysWorked,int vaccationDaysTaken,double salary,int yearsWorked,int salesMade){
        super(firstName,lastName,registration,age,daysWorked,vaccationDaysTaken,salary,yearsWorked);
        this.salesMade=salesMade;
    }
    public int calculateComission(){
        // comission = 0.1 * salesMade
        return (int) (0.1*salesMade);
    }
}

class SalesManager extends salesRep {
    HashMap<Integer, salesRep> team;

    public SalesManager(String firstName, String lastName, int registration, int age, int daysWorked,
                        int vacationDaysTaken, double salary, int yearsWorked, int salesMade, HashMap<Integer, salesRep> team) {
        super(firstName, lastName, registration, age, daysWorked, vacationDaysTaken, salary, yearsWorked, salesMade);
        this.team = team;
    }
    public int calculateCommission() {
        int totalSales = team.values().stream().mapToInt(rep -> (int) rep.salesMade).sum();
        return (int) (0.03 * totalSales);
    }
}



public class HR_System {
    public static void main(String[] args) {
        salesRep rep1 = new salesRep("John", "Doe", 101, 35, 300, 5, 60000, 8, 50);
        salesRep rep2 = new salesRep("Jane", "Smith", 102, 40, 250, 10, 65000, 10, 70);

        Map<Integer, salesRep> team = new HashMap<>(); // Using HashMap
        team.put(rep1.registration, rep1);
        team.put(rep2.registration, rep2);

        SalesManager manager = new SalesManager("Alex", "Johnson", 103, 45, 500, 15, 80000.0, 15, 150, (HashMap<Integer, salesRep>) team);

        // Test functionalities
        System.out.println("Time to retirement for salesmanager: " + manager.timeToRetirement());
        System.out.println("Vacation time left for rep: " + rep1.vacationTimeLeft());
        System.out.println("Bonus for rep2: " + rep2.calculateBonus());
        System.out.println("Commission for manager's team: " + manager.calculateCommission());
    }
}

