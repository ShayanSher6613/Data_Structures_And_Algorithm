import java.util.Scanner;

public class ArrayOperations {
    static Scanner input = new Scanner(System.in);
    static int[] array;
    static int MaximumSize;
    static int size = 0;

    public static void main(String[] args) {
        System.out.print("Enter the capacity of the array: ");
        MaximumSize = input.nextInt();
        array = new int[MaximumSize];

        System.out.print("Enter the number of initial elements: ");
        int initialSize = input.nextInt();

        if (initialSize > 0 && initialSize <= MaximumSize) {
            System.out.println("Enter " + initialSize + " elements:");
            for (int i = 0; i < initialSize; i++) {
                array[i] = input.nextInt();
                size++;
            }
        }

        int choice;
        while (true) {
            displayMenu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    traversal();
                    break;
                case 2:
                    insertMenu();
                    break;
                case 3:
                    deleteMenu();
                    break;
                case 4:
                    searchElement();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            if (choice != 5) {
                System.out.println("\nPress Enter to continue...");
                input.nextLine();
                input.nextLine();
            }
        }
    }

    public static void displayMenu() {
        System.out.println("\n============================");
        System.out.println("   ARRAY OPERATIONS MENU");
        System.out.println("============================");
        System.out.println("1. Traversal");
        System.out.println("2. Insert Element");
        System.out.println("3. Delete Element");
        System.out.println("4. Search Element");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void traversal() {
    System.out.println("\n--- ARRAY TRAVERSAL ---");
    if (size == 0) {
        System.out.println("Array is empty!");
        return;
    }

    System.out.print("Array elements: ");
    for (int i = 0; i < size; i++) {
        System.out.print(array[i]);
        if (i < size - 1) {
            System.out.print(", ");
        }
    }
    System.out.println();
    System.out.println("Total elements: " + size);
}

    public static void insertMenu() {
        if (size >= MaximumSize) {
            System.out.println("Array is full! Cannot insert more elements.");
            return;
        }

        System.out.println("\n--- INSERT ELEMENT ---");
        System.out.println("1. Insert at Beginning");
        System.out.println("2. Insert at Given Position");
        System.out.println("3. Insert at End");
        System.out.print("Enter your choice: ");

        int insertChoice = input.nextInt();
        System.out.print("Enter element to insert: ");
        int element = input.nextInt();

        switch (insertChoice) {
            case 1:
                insertAtBeginning(element);
                break;
            case 2:
                System.out.print("Enter position (0 to " + size + "): ");
                int pos = input.nextInt();
                insertAtPosition(element, pos);
                break;
            case 3:
                insertAtEnd(element);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void insertAtBeginning(int element) {
        if (size >= MaximumSize) {
            System.out.println("Array is full!");
            return;
        }
        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = element;
        size++;
        System.out.println("Element " + element + " inserted at beginning successfully!");
    }

    public static void insertAtPosition(int element, int position) {
        if (size >= MaximumSize) {
            System.out.println("Array is full!");
            return;
        }
        if (position < 0 || position > size) {
            System.out.println("Invalid position! Position should be between 0 and " + size);
            return;
        }
        for (int i = size; i > position; i--) {
            array[i] = array[i - 1];
        }
        array[position] = element;
        size++;
        System.out.println("Element " + element + " inserted at position " + position + " successfully!");
    }

    public static void insertAtEnd(int element) {
        if (size >= MaximumSize) {
            System.out.println("Array is full!");
            return;
        }
        array[size] = element;
        size++;
        System.out.println("Element " + element + " inserted at end successfully!");
    }

    public static void deleteMenu() {
        if (size == 0) {
            System.out.println("Array is empty! Cannot delete elements.");
            return;
        }

        System.out.println("\n--- DELETE ELEMENT ---");
        System.out.println("1. Delete from Beginning");
        System.out.println("2. Delete from Given Position");
        System.out.println("3. Delete from End");
        System.out.print("Enter your choice: ");

        int deleteChoice = input.nextInt();

        switch (deleteChoice) {
            case 1:
                deleteFromBeginning();
                break;
            case 2:
                System.out.print("Enter position (0 to " + (size - 1) + "): ");
                int pos = input.nextInt();
                deleteFromPosition(pos);
                break;
            case 3:
                deleteFromEnd();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void deleteFromBeginning() {
        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }

        int deletedElement = array[0];
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
        System.out.println("Element " + deletedElement + " deleted from beginning successfully!");
    }

    public static void deleteFromPosition(int position) {
        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }

        if (position < 0 || position >= size) {
            System.out.println("Invalid position! Position should be between 0 and " + (size - 1));
            return;
        }

        int deletedElement = array[position];
        for (int i = position; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
        System.out.println("Element " + deletedElement + " deleted from position " + position + " successfully!");
    }

    public static void deleteFromEnd() {
        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }

        int deletedElement = array[size - 1];
        size--;
        System.out.println("Element " + deletedElement + " deleted from end successfully!");
    }

    public static void searchElement() {
        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }

        System.out.println("\n--- LINEAR SEARCH ---");
        System.out.print("Enter element to search: ");
        int key = input.nextInt();

        int position = linearSearch(key);

        if (position != -1) {
            System.out.println("Element " + key + " found at position: " + position);
        } else {
            System.out.println("Element " + key + " not found in the array!");
        }
    }

    public static int linearSearch(int key) {
        for (int i = 0; i < size; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
}





/*Traversal Algorithm
1)Start.
2)Check if size (the number of elements in the array) is 0.
3)If size is 0, print "Array is empty" and go to Step 8.
4)If size is not 0, print "Array elements: ".
5)Initialize a loop counter i to 0.
6)Loop while i is less than size:
a. Print the element at array[i].
b. If i is less than size - 1, print ", " to separate the elements.
c. Increment i by 1.
7)Print a new line.
8)End.

Insertion Algorithm
1)Start.
2)Check if size is equal to capacity. If so, print "Array is full" and go to Step 7.
3)Store the element to be inserted in a variable, say element.
4)Initialize a loop counter i to size.
5)Loop while i is greater than 0:
a. Copy the element from array[i - 1] to array[i].
b. Decrement i by 1.
6)Place element at array[0].
7(Increment size by 1.
8)Print a success message.
9)End.

2. Insert at a Given Position
1)Start.
2)Check if size is equal to capacity. If so, print "Array is full" and go to Step 8.
3)Check if the given position is valid (between 0 and size). If not, print "Invalid position" and go to Step 8.
4)Store the element to be inserted in a variable, say element.
5)Initialize a loop counter i to size.
6)Loop while i is greater than position:
a. Copy the element from array[i - 1] to array[i].
b. Decrement i by 1.
7)Place element at array[position].
8)Increment size by 1.
9)Print a success message.
10)End.

3. Insert at End
1)Start.
2)Check if size is equal to capacity. If so, print "Array is full" and go to Step 5.
3)Store the element to be inserted in a variable, say element.
4)Place element at array[size].
5)Increment size by 1.
6)Print a success message.
7)End.

Deletion Algorithm
1)Start.
2)Check if size is 0. If so, print "Array is empty" and go to Step 6.
3)Store the element at array[0] in a temporary variable, e.g., deletedElement.
4)Initialize a loop counter i to 0.
5)Loop while i is less than size - 1:
a. Copy the element from array[i + 1] to array[i].
b. Increment i by 1.
6)Decrement size by 1.
7)Print a success message including deletedElement.
8)End.

2. Delete from a Given Position
1)Start.
2)Check if size is 0. If so, print "Array is empty" and go to Step 7.
3)Check if the given position is valid (between 0 and size - 1). If not, print "Invalid position" and go to Step 7.
4)Store the element at array[position] in a temporary variable, e.g., deletedElement.
5)Initialize a loop counter i to position.
6)Loop while i is less than size - 1:
a. Copy the element from array[i + 1] to array[i].
b. Increment i by 1.
7)Decrement size by 1.
8)Print a success message including deletedElement.
9)End.

3. Delete from End
1)Start.
2)Check if size is 0. If so, print "Array is empty" and go to Step 5.
3)Store the element at array[size - 1] in a temporary variable, e.g., deletedElement.
4)Decrement size by 1.
5)Print a success message including deletedElement.
6)End.

Searching Algorithm (Linear Search)
1)Start.
2)Check if size is 0. If so, print "Array is empty" and go to Step 6.
3)Store the element to be searched for in a variable, say key.
4)Initialize a loop counter i to 0.
5)Loop while i is less than size:
a. Check if the element at array[i] is equal to key.
b. If it is, print a success message showing the index i and go to Step 7.
c. Increment i by 1.
6)If the loop finishes without finding key, print "Element not found".
7)End.*/