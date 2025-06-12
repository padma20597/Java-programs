import java.util.HashMap;
import java.util.Scanner;
public class PhoneBook {
    private HashMap<String, String> contacts;
    private Scanner scanner;
    public PhoneBook() {
        contacts = new HashMap<>();
        scanner = new Scanner(System.in);
    }
    public void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String number = scanner.nextLine();
        contacts.put(name, number);
        System.out.println("Contact added.");
    }
    public void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook is empty.");
        } else {
            System.out.println("Contacts:");
            for (HashMap.Entry<String, String> entry : contacts.entrySet()) {
                System.out.println("Name: " + entry.getKey() + ", Number: " + entry.getValue());
            }
        }
    }
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nPhonebook Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. View Contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    phoneBook.addContact();
                    break;
                case 2:
                    phoneBook.deleteContact();
                    break;
                case 3:
                    phoneBook.viewContacts();
                    break;
                case 0:
                    System.out.println("Exiting phonebook.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        scanner.close();
    }
}