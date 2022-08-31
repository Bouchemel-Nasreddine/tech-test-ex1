import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class ExerciseOne {

    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Client> clients = new ArrayList<>();


    public static void main(String[] args) throws ParseException, IOException {

      employees.add(new Employee(
                "nasro",
                new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2000"),
                new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2000"),
                100.00,
                false,
                0
        ));

        clients.add(new Client(
                "nasroooo",
                new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2000"),
                new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2000"),
                100.00,
                false,
                0
        ));

//        System.out.println(employees.get(0).getIdentifier());
//        System.out.println(clients.get(0).getIdentifier());
//
//        employees.get(0).contactClient(clients, clients.get(0).getIdentifier());


//        System.out.println(clients.get(0).getIdentifier());

        String operation = "";
        ArrayList<String> operations = new ArrayList<>() {
            {
                add("0");
                add("1");
                add("2");
                add("3");
                add("4");
            }
        };

        while (!operation.equals("exit")) {
            System.out.println("type the number corresponding to the operation you want to execute: \n0: create an employee \n1: create an client \n2: associate a employee to a client \n3: show the list of clients and their employees \nfor ending the program type \"exit\"");

            BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

            operation = reader.readLine();

            if (!operations.contains(operation) || !operation.equals("exit") ) {
                System.out.println("*******please indicate a correct operation number from the list*******");
            }

            switch (operation) {
                case "0":
                    employees.add(Utils.createEmployee());
                    System.out.println("employee created successfully");
                    break;
                case "1":
                    clients.add(Utils.createClient());
                    System.out.println("client created successfully");
                    break;
                case "2":
                    Utils.associateEmployeeToCLient(clients, employees);
                    break;
                case "3":
                    Utils.showClientsWithEmployees(clients, employees);
                    break;
                case "4":
                    System.out.println(employees);
                    break;
            }

        }

        System.out.println("you have ended the program");

//        BufferedReader reader = new BufferedReader(
//                new InputStreamReader(System.in));
//
//        // Reading data using readLine
//        name = reader.readLine();
//
//        // Printing the read line
//        System.out.println(name);

    }



}
