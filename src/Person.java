import java.util.Date;
import java.util.UUID;

public class Person {

    String identifier;
    String fullName;
    Date dBirth;
    Date dHired;
    double salary;
    boolean martialStatus;
    int numberOfChildren;

    public Person(String fullName, Date dBirth, Date dHired, double salary, boolean martialStatus, int numberOfChildren) {
        identifier = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.dBirth = dBirth;
        this.dHired = dHired;
        this.salary = salary;
        this.martialStatus = martialStatus;
        this.numberOfChildren = numberOfChildren;
    }

    public Person() {

    }


    public String getIdentifier() {
        return identifier;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getdBirth() {
        return dBirth;
    }

    public Date getdHired() {
        return dHired;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isMartialStatus() {
        return martialStatus;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    @Override
    public String toString() {
        return this.fullName;
    }


}
