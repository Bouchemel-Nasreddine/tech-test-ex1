import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.UUID; //for creating random ids for employees


public class Employee extends Person {

    //The relation between a client and an employee, as the text mentions, is that an employee has at most one client
    //and for the client side, he's associated with multiple employees, so to demonstrate this relation (0..1, 0..n)
    //from a code point of view, the employee would have a nullable attribute that refers to the client he's associated
    //with.
    @Nullable
    private Client client;

    public Employee(String fullName, Date dBirth, Date dHired, double salary, boolean martialStatus, int numberOfChildren) {
        this.identifier = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.dBirth = dBirth;
        this.dHired = dHired;
        this.salary = salary;
        this.martialStatus = martialStatus;
        this.numberOfChildren = numberOfChildren;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void contactClient(ArrayList<Client> clients, String clientId) {
        for (Client value : clients) {
            if (Objects.equals(value.getIdentifier(), clientId)) {
                System.out.println("hello " + value.getFullName());
                break;
            }
        }
    }

    public void quitJob(ArrayList<Employee> employees) {
        for (Employee e : employees) {
            if (e.equals(this)) {
                employees.remove(e);
                break;
            }
        }
    }

    public void takeSalary(double newSalary) {
        this.salary = newSalary;
    }
}
