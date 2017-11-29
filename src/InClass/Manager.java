package InClass;

public class Manager extends Employee {
    private double bonus;

    public Manager(double aBonus, double aSalary, String aName) {
        super(aName,aSalary);
        this.bonus = aBonus;
    }
    @Override
    public double getSalary() {
        return super.getSalary() + this.getBonus();
    }

    public double getBonus() {
        return bonus;
    }
}
