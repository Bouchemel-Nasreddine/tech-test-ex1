import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.UUID; //for creating random ids for clients

public class Client extends Person {

    public Client(String fullName, Date dBirth, Date dHired, double salary, boolean martialStatus, int numberOfChildren) {
        identifier = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.dBirth = dBirth;
        this.dHired = dHired;
        this.salary = salary;
        this.martialStatus = martialStatus;
        this.numberOfChildren = numberOfChildren;
    }

    public boolean equals(Client o) {
        return this.identifier.equals(o.getIdentifier());
    }

}

