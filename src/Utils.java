import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Utils {

    public static Employee createEmployee() throws IOException {
        String name;
        Date dBirth;
        Date dHired;
        double salary;
        boolean mStatus;
        int nChildren;

        System.out.println("indicate employee name:");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        name = buffer.readLine();

        System.out.println("indicate employee d of birth(format dd/MM/yyyy):");
        while (true) {
            buffer = new BufferedReader(new InputStreamReader(System.in));
            try {
                dBirth = new SimpleDateFormat("dd/MM/yyyy").parse(buffer.readLine());
                break;
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("please make sure the format is dd/MM/yyyy");
            }

        }

        System.out.println("indicate employee d of hiring:");
        while (true) {
            buffer = new BufferedReader(new InputStreamReader(System.in));
            try {
                dHired = new SimpleDateFormat("dd/MM/yyyy").parse(buffer.readLine());
                break;
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("please make sure the format is dd/MM/yyyy");
            }

        }

        System.out.println("indicate employee salary:");
        buffer = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                salary = Double.parseDouble(buffer.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("number format must be a valid float number");
            }
        }
        System.out.println("is the employee married (y/n):");
        while (true) {
            buffer = new BufferedReader(new InputStreamReader(System.in));
            String answer = buffer.readLine();
            if (!answer.equals("y") && !answer.equals("n"))
            {
                System.out.println("answer should be y or n");
            } else {
                mStatus = answer.equals("y");
                break;
            }
        }
        System.out.println("how many children does the employee have:");
        buffer = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                nChildren = Integer.parseInt(buffer.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("number format must be a valid integer");
            }
        }

        return new Employee(name, dBirth, dHired, salary, mStatus, nChildren);
    }

    public static Client createClient() throws IOException {
        String name;
        Date dBirth;
        Date dHired;
        double salary;
        boolean mStatus;
        int nChildren;

        System.out.println("indicate client name:");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        name = buffer.readLine();

        System.out.println("indicate client d of birth(format dd/MM/yyyy):");
        while (true) {
            buffer = new BufferedReader(new InputStreamReader(System.in));
            try {
                dBirth = new SimpleDateFormat("dd/MM/yyyy").parse(buffer.readLine());
                break;
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("please make sure the format is dd/MM/yyyy");
            }

        }

        System.out.println("indicate client d of hiring:");
        while (true) {
            buffer = new BufferedReader(new InputStreamReader(System.in));
            try {
                dHired = new SimpleDateFormat("dd/MM/yyyy").parse(buffer.readLine());
                break;
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("please make sure the format is dd/MM/yyyy");
            }

        }

        System.out.println("indicate client salary:");
        buffer = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                salary = Double.parseDouble(buffer.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("number format must be a valid float number");
            }
        }
        System.out.println("is the client married (y/n):");
        while (true) {
            buffer = new BufferedReader(new InputStreamReader(System.in));
            String answer = buffer.readLine();
            if (!answer.equals("y") && !answer.equals("n"))
            {
                System.out.println("answer should be y or n");
            } else {
                mStatus = answer.equals("y");
                break;
            }
        }
        System.out.println("how many children does the client have:");
        buffer = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                nChildren = Integer.parseInt(buffer.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("number format must be a valid integer");
            }
        }

        return new Client(name, dBirth, dHired, salary, mStatus, nChildren);
    }

    public static void showClientsWithEmployees(ArrayList<Client> clients, ArrayList<Employee> employees) {
        for (Client c : clients) {
            System.out.println("****************");
            System.out.println(c);
            System.out.println("employees:");
            for (Employee e : employees) {
                if (e.getClient() == null) continue;
                if (c.equals(e.getClient())) {
                    System.out.println(e);
                }
            }
        }
    }


    public static void associateEmployeeToCLient(ArrayList<Client> clients, ArrayList<Employee> employees) throws IOException {
        System.out.println("type the name of the client you want to associate to");
        System.out.println(clients);
        while (true) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
            String finalName = name;
            Client c = clients.stream()
                .filter(client -> finalName.equals(client.getFullName()))
                .findAny()
                .orElse(null);

        if (c == null) {
            System.out.println("couldnt find this name, make sure it is wright");
        } else {
            System.out.println("type the name of the employee you want to associate to the client " + c.getFullName());
            System.out.println(employees);
            while (true) {
                reader = new BufferedReader(new InputStreamReader(System.in));
                name = reader.readLine();
                String finalName1 = name;
                Employee e = employees.stream()
                        .filter(employee -> finalName1.equals(employee.getFullName()))
                        .findAny()
                        .orElse(null);

                if (e == null) {
                    System.out.println("couldnt find this name, make sure it is wright");
                } else {
                    e.setClient(c);
                    System.out.println("association done successfully");
                    break;
                } }
            break;
        } }

    }

}
