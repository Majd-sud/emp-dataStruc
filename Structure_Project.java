package structure_project;

public class Structure_Project {
    private Node head;

    public Structure_Project() {
        head = null;
    }

    public int InsertEmployeeRecord(int ID, String name, String firstDay, int phoneNumber, String address, int workHours, double salary) {
        Node newNode = new Node();
        newNode.employee_ID = ID;
        newNode.employee_Name = name;
        newNode.first_Day_Work = firstDay;
        newNode.employee_Phone_Number = phoneNumber;
        newNode.employee_Address = address;
        newNode.employee_Work_Hours = workHours;
        newNode.employee_Salary = salary;
        newNode.next_Node = null;

        if (head == null || head.employee_ID >= ID) {
            newNode.next_Node = head;
            head = newNode;
            return 0; // Successfully inserted at head
        }

        Node current = head;
        while (current.next_Node != null && current.next_Node.employee_ID < ID) {
            current = current.next_Node;
        }

        newNode.next_Node = current.next_Node;
        current.next_Node = newNode;
        return 0; // Successfully inserted
    }

    public int DeleteEmployeeRecord(int ID) {
        if (head == null) {
            return -1; // List is empty
        }

        if (head.employee_ID == ID) {
            head = head.next_Node;
            return 0; // Successfully deleted
        }

        Node current = head;
        while (current.next_Node != null) {
            if (current.next_Node.employee_ID == ID) {
                current.next_Node = current.next_Node.next_Node;
                return 0; // Successfully deleted
            }
            current = current.next_Node;
        }
        return -1; // ID not found
    }

    public void updateEmployeeRecord(int ID) {
        Node current = head;
        while (current != null) {
            if (current.employee_ID == ID) {
                // Assume updates are done via another method or interface interaction
                break;
            }
            current = current.next_Node;
        }
    }

    public String ShowEmployeeDetails() {
        StringBuilder details = new StringBuilder();
        Node current = head;
        while (current != null) {
            details.append("ID: ").append(current.employee_ID)
                    .append(", Name: ").append(current.employee_Name)
                    .append(", First Day: ").append(current.first_Day_Work)
                    .append(", Phone: ").append(current.employee_Phone_Number)
                    .append(", Address: ").append(current.employee_Address)
                    .append(", Work Hours: ").append(current.employee_Work_Hours)
                    .append(", Salary: $").append(current.employee_Salary)
                    .append("\n");
            current = current.next_Node;
        }
        return details.toString();
    }
}
