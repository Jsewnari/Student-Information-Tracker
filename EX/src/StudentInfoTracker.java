import java.util.*;

public class StudentInfoTracker {

    private static void bubbleSort(int[] intArray) {
        int n = intArray.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (intArray[j - 1] > intArray[j]) {
                    //swap the elements!
                    temp = intArray[j - 1];
                    intArray[j - 1] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Information Tracker!");
        System.out.println("How many students are in the class: ");
        int number = scanner.nextInt();

        String[] names = new String[number];
        List<String> studentData = new ArrayList<>();
        Stack<Integer> studentGrades = new Stack<>();
        int[] gradesArray = new int[number];
        Queue<String> assignmentCompletion = new LinkedList<>();
        HashMap<String, Integer> studentID = new HashMap<>();

        for (int i = 0; i < number; i++) {
            System.out.println("Please enter student name: ");
            names[i] = scanner.next();
        }

        for (int i = 0; i < 8; i++) {
            System.out.println("Please select an option:");
            System.out.println("1: Enter Student Names");
            System.out.println("2: Add or Delete Student Names");
            System.out.println("3: Replace Student Names");
            System.out.println("4: Enter Student Grades");
            System.out.println("5: Sort Grades");
            System.out.println("6: Submit Student Assignments");
            System.out.println("7: Enter Student ID Numbers");
            System.out.println("8: Exit Program");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Here are the student names: ");
                    for (String name : names) {
                        System.out.println(name);
                    }
                    break;
                case 2:
                    studentData.addAll(Arrays.asList(names));
                    System.out.println("Here is the student data before we add, remove, or replace any students: ");
                    System.out.println(studentData);
                    System.out.println("Would you like to add or delete students from your list: ");
                    System.out.println("type 'add' to add and 'delete' to delete a student: ");
                    String response = scanner.next();
                    if (response.equals("add")) {
                        System.out.println("What is the student name: ");
                        String ans = scanner.next();
                        studentData.add(ans);
                        number += 1;
                    }
                    if (response.equals("delete")) {
                        System.out.println("What is the student name: ");
                        String ans2 = scanner.next();
                        studentData.remove(ans2);
                        number -= 1;
                    }
                    System.out.println("Here are the names after these changes: ");
                    System.out.println(studentData);
                    break;
                case 3:
                    System.out.println("Enter the index you would like to replace: ");
                    int index = scanner.nextInt();
                    System.out.println("What is the name of the student: ");
                    String nameEntered = scanner.next();
                    studentData.set(index, nameEntered);
                    System.out.println("Here are the names after these changes: ");
                    System.out.println(studentData);
                    break;
                case 4:
                    System.out.println("Lets assign what grade each student got on their math exam: ");
                    for (int j = 0; j < studentData.size(); j++) {
                        String student = studentData.get(j);
                        System.out.println("What did " + student + " get: ");
                        int grade = scanner.nextInt();
                        studentGrades.push(grade);
                        gradesArray[j] = grade;
                    }
                    System.out.println("Here are the student names and their grades:");
                    for (String student : studentData) {
                        int grade = studentGrades.pop();
                        System.out.println(student + " - Grade: " + grade);
                    }
                    break;
                case 5:
                    System.out.println("Would you like to sort the grades of students from lowest to highest? y or n");
                    String sort = scanner.next();
                    if (sort.equalsIgnoreCase("y")) {
                        bubbleSort(gradesArray);
                        System.out.println("Grades After Sort");
                        for (int j : gradesArray) {
                            System.out.print(j + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 6:
                    System.out.println("Lets have students submit the assignments: ");
                    for (String student : studentData) {
                        System.out.println(student + " what assignment would you like to submit: ");
                        String answer = scanner.next();
                        assignmentCompletion.offer(answer);
                    }
                    System.out.println("Here are the students and their respective assignments: ");
                    for (String student : studentData) {
                        String answer = assignmentCompletion.poll();
                        System.out.println(student + " here is your assignment: " + answer);
                    }
                    break;
                case 7:
                    System.out.println("Assign each of the students a Unique student ID");
                    for (String studentTracker : studentData) {
                        System.out.println(studentTracker + " please enter the student ID: ");
                        int ID = scanner.nextInt();
                        studentID.put(studentTracker, ID);
                    }
                    for (String studentInfo : studentData) {
                        int studentTracker = studentID.get(studentInfo);
                        System.out.println(studentInfo + " - ID: " + studentTracker);
                    }
                    break;
                case 8:
                    System.out.println("Exiting Program");
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}