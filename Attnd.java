import java.util.*;

class Attendance {
    private String id;
    private List<String> facultyNames;
    private List<String> letters;
    List<String> days;
    private Scanner sc;
    private int pw1 = 123;
    private int pw2 = 123;
    private int pw3 = 123;
    boolean flag = true;

    public Attendance() {
        facultyNames = new ArrayList<>();
        facultyNames.add("CVM");
        facultyNames.add("MMP");
        facultyNames.add("DRS");

        letters = new ArrayList<>(Collections.nCopies(30, null));
        days = new ArrayList<>(Collections.nCopies(4, ""));

        sc = new Scanner(System.in);
    }

    void letter(List<String> letters) {
        System.out.println("-------------------------------------------------");
        System.out.println("Message");
        System.out.println("-------------------------------------------------");
        System.out.println("Enter roll number");
        int n = sc.nextInt();
        System.out.println("-------------------------------------------------");
        System.out.println("Type your message");
        sc.nextLine();
        String letter = sc.nextLine();
        letters.set(n, letter);
    }

    void displayLetter() {
        boolean flag = false;
        for (int i = 0; i < letters.size(); i++) {
            if (letters.get(i) != null) {
                System.out.println("---------------------------");
                System.out.println("Roll no: " + i);
                System.out.println(letters.get(i));
                System.out.println("---------------------------");
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No message in inbox");
        }
    }

    void attend(List<Boolean> attendanceList) {
        System.out.println("1. Enter roll number for attendance.");
        System.out.println("2. Enter 0 to type a message for faculty.");

        for (int k = 0;; k++) {
            int n = sc.nextInt();
            for (int i = 0; i < attendanceList.size(); i++) {
                if ((n - 1) == i) {
                    attendanceList.set(i, true);
                } else if (n == 123 || n == 345 || n == 567) {
                    System.out.println(
                            "Faculty entered, you are not allowed to sit in class, your attendance filled automatically");
                    System.out.println(
                            "----------------------------------------------------------------------------------------------------------");
                    return;
                } else if (n == 0) {
                    letter(letters);
                    System.out.println("-------------------------------------------------");
                    break;
                }
            }
        }
    }

    void lecture() {
        boolean flag = false;
        System.out.println("Enter today's day");
        while (true) {
            String y = sc.nextLine();
            switch (y) {
                case "monday":
                    days.set(0, "JAVA");
                    days.set(1, "JAVA");
                    days.set(2, "ENVIORNMENTAL SCIENCE");
                    days.set(3, "MATHS");
                    flag = true;
                    break;
                case "tuesday":
                    days.set(0, "JAVA");
                    days.set(1, "JAVA");
                    days.set(2, "MATHS");
                    days.set(3, "MATHS");
                    flag = true;
                    break;
                case "wednesday":
                    days.set(0, "MATHS");
                    days.set(1, "MATHS");
                    days.set(2, "PHYSICS");
                    days.set(3, "PHYSICS");
                    flag = true;
                    break;
                case "thursday":
                    days.set(0, "JAVA");
                    days.set(1, "JAVA");
                    days.set(2, "PHYSICS");
                    days.set(3, "PHYSICS");
                    flag = true;
                    break;
                case "friday":
                    days.set(0, "JAVA");
                    days.set(1, "JAVA");
                    days.set(2, "PHYSICS");
                    days.set(3, "PHYSICS");
                    flag = true;
                    break;
                case "saturday":
                    days.set(0, "PHYSICS");
                    days.set(1, "PHYSICS");
                    days.set(2, "SOFTWARE ENGINEERING");
                    days.set(3, "SOFTWARE ENGINEERING");
                    flag = true;
                    break;
            }
            if (flag == false)
                System.out.println("invalid, try again.");
            else
                return;
        }
    }

    public void print(List<Boolean> class1Attendance) {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        int i = 1;
        for (boolean attendance : class1Attendance) {
            if (attendance) {
                System.out.println(i + " is present");
            } else {
                System.out.println(i + " is absent");
            }
            i++;
        }
    }

    public void total(List<Integer> com, List<Boolean> class1Attendance) {
        for (int i = 0; i < com.size(); i++) {
            if (class1Attendance.get(i)) {
                com.set(i, com.get(i) + 1);
            }
        }
    }

    public void display(List<Integer> com) {
        for (int i = 0; i < com.size(); i++) {
            if (com.get(i) <= 1) {
                System.out.println("Roll no " + (i + 1) + " attended " + com.get(i) + " lecture");
            } else {
                System.out.println("Roll no " + (i + 1) + " attended " + com.get(i) + " lectures");
            }
        }
    }

    public void change() {
    }

    public void login() {
        boolean b1 = false;
        System.out.println("Enter your id");
        sc.nextLine();
        while (b1 == false) {
            String id = sc.nextLine();
            this.id = id;
            if (facultyNames.contains(id)) {
                b1 = true;
            } else {
                System.out.println("User Name not found");
            }
        }
        System.out.println("----------------------------------------------------");
        System.out.println("Enter Password");
        if (b1 == true) {
            for (int i = 0; i < 3; i++) {
                int n = sc.nextInt();
                if (id.equals("CVM")) {

                    if (n == pw1) {
                        System.out.println("-------------------------------------");
                        System.out.println("Login successful");
                        System.out.println("-------------------------------------");
                        break;
                    } else {
                        b1 = false;
                        System.out.println("Incorrect password.");
                    }
                }
                if (id.equals("MMP")) {
                    if (n == pw2) {
                        System.out.println("-------------------------------------");
                        System.out.println("Login successful");
                        System.out.println("-------------------------------------");
                        break;
                    } else {
                        b1 = false;
                        System.out.println("Incorrect password.");
                    }
                }
                if (id.equals("DRS")) {
                    if (n == pw3) {
                        System.out.println("-------------------------------------");
                        System.out.println("Login successful");
                        System.out.println("-------------------------------------");
                        break;
                    } else {
                        b1 = false;
                        System.out.println("Incorrect password.");
                    }
                }
            }
            if (b1 == false) {
                this.flag = b1;
                System.out.println("Incorrect password,try again after few minutes");
                return;
            }
        }
    }

    public boolean getFlag() {
        return false;
    }

}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> com = new ArrayList<>(Collections.nCopies(30, 0));
        List<Boolean> class1Attendance = new ArrayList<>(Collections.nCopies(30, false));
        List<Boolean> class2Attendance = new ArrayList<>(Collections.nCopies(30, false));
        List<Boolean> class3Attendance = new ArrayList<>(Collections.nCopies(30, false));
        List<Boolean> class4Attendance = new ArrayList<>(Collections.nCopies(30, false));

        Attendance A = new Attendance();
        A.lecture();
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("First lecture is " + A.days.get(0));
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        A.attend(class1Attendance);
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Next lecture is " + A.days.get(1));
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        A.attend(class2Attendance);
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Next lecture is " + A.days.get(2));
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        A.attend(class3Attendance);
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Next lecture is " + A.days.get(3));
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        A.attend(class4Attendance);

        boolean b = true;
        while (b == true) {
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------");
            // System.out.println("1. Faculty access");
            System.out.println("2. Student access");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    A.login();
                    sc.nextLine();
                    if (A.getFlag()) {
                        while (true) {
                            System.out.println("---------------------------------------------------------");
                            System.out.println("Enter 'attendance' for today's attendance sheet.");
                            System.out.println("Enter 'message' to see messages.");
                            System.out.println("Enter 'total' to get total attendance.");
                            System.out.println("Enter 'reset' to change faculty username or code.");
                            System.out.println("Enter 'Exit' to exit.");
                            System.out.println("Enter 'over' to exit the program.");
                            System.out.println("---------------------------------------------------------");
                            String option = sc.nextLine();
                            if (option.equalsIgnoreCase("attendance")) {
                                System.out.println(
                                        "----------------------------------------------------------------------------------------------------------");
                                System.out.println(" In " + A.days.get(0) + " lecture");
                                A.print(class1Attendance);
                                System.out.println(
                                        "----------------------------------------------------------------------------------------------------------");
                                System.out.println(" In " + A.days.get(1) + " lecture");
                                A.print(class2Attendance);
                                System.out.println(
                                        "----------------------------------------------------------------------------------------------------------");
                                System.out.println(" In " + A.days.get(2) + " lecture");
                                A.print(class3Attendance);
                                System.out.println(
                                        "----------------------------------------------------------------------------------------------------------");
                                System.out.println(" In " + A.days.get(3) + " lecture");
                                A.print(class4Attendance);
                            } else if (option.equalsIgnoreCase("message")) {
                                A.displayLetter();
                            } else if (option.equalsIgnoreCase("Exit")) {
                                break;
                            } else if (option.equalsIgnoreCase("Total")) {
                                A.total(com, class1Attendance);
                                A.total(com, class2Attendance);
                                A.total(com, class3Attendance);
                                A.total(com, class4Attendance);
                                A.display(com);
                            } else if (option.equalsIgnoreCase("reset")) {
                                A.change();
                                System.out.println("---------------------------------------------------------");
                            } else if (option.equalsIgnoreCase("over")) {
                                b = false;
                                break;
                            } else {
                                System.out.println("Enter a valid option.");
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter 'attendance' to get today's attendance");
                    System.out.println("Enter 'total' to get total attendance");
                    sc.nextLine();
                    String option = sc.nextLine();
                    if (option.equalsIgnoreCase("attendance")) {
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------");
                        System.out.println(" In " + A.days.get(0) + " lecture");
                        A.print(class1Attendance);
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------");
                        System.out.println(" In " + A.days.get(1) + " lecture");
                        A.print(class2Attendance);
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------");
                        System.out.println(" In " + A.days.get(2) + " lecture");
                        A.print(class3Attendance);
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------");
                        System.out.println(" In " + A.days.get(3) + " lecture");
                        A.print(class4Attendance);
                    } else if (option.equalsIgnoreCase("total")) {
                        A.total(com, class1Attendance);
                        A.total(com, class2Attendance);
                        A.total(com, class3Attendance);
                        A.total(com, class4Attendance);
                        A.display(com);
                    } else {
                        System.out.println("Enter a valid option.");
                    }
                    break;
            }
        }
    }
}
