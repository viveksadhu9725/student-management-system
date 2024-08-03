/*Student Management System
Developed a Java-based Student Management System with a relational database, featuring modules for adding/removing students, tracking attendance, automating grades, managing class schedules, and processing leave requests.*/
import java.sql.*;
import java.util.*;
import java.io.*;

class Password {

    String name;
    String password;

    public Password(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}

class studentinfo {

    public static long enrollmentNoForPrint;
    public static double gradePoint;

    static void addstudentrecord() throws Exception {

        Scanner sc = new Scanner(System.in);
        // Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "");
        Statement st = con.createStatement();

        System.out.println("------------------------------------------");
        System.out.println("enter student branch : ");
        String branch = sc.nextLine();
        System.out.println("enter student batch : ");
        String batch = sc.nextLine();
        System.out.println("enter student roll no : ");
        int rollno = sc.nextInt();
        System.out.println("enter student enrollment number : ");
        long enrollmentNo = sc.nextLong();
        sc.nextLine();
        System.out.println("enter student name : ");
        String name = sc.nextLine();
        System.out.println("enter maths marks : ");
        int mathsMarks = sc.nextInt();
        System.out.println("enter physics theory marks : ");
        int physicsThMarks = sc.nextInt();
        System.out.println("enter physics practical marks : ");
        int physicsPraMarks = sc.nextInt();
        System.out.println("enter java theory marks : ");
        int javaThMarks = sc.nextInt();
        System.out.println("enter java practical marks : ");
        int javaPraMarks = sc.nextInt();
        System.out.println("enter SE theory marks : ");
        int seThMarks = sc.nextInt();
        System.out.println("enter SE practical marks : ");
        int sePraMarks = sc.nextInt();
        System.out.println("enter IOT marks : ");
        int iotMarks = sc.nextInt();
        System.out.println("enter CWS marks : ");
        int cwsMarks = sc.nextInt();
        System.out.println("enter ES marks : ");
        int esMarks = sc.nextInt();
        System.out.println("------------------------------------------");

        String sql = "insert into studentrecord(branch,batch,rollNo,enrollmentNo,name,mathsMarks,physicsThMarks,physicsPraMarks,javaThMarks,javaPraMarks,seThMarks,sePraMarks,iotMarks,cwsMarks,esMarks)values('"
                + branch + "','" + batch + "'," + rollno + "," + enrollmentNo + ",'" + name + "'," + mathsMarks + ","
                + physicsThMarks + "," + physicsPraMarks + "," + javaThMarks + "," + javaPraMarks + "," + seThMarks
                + ","
                + sePraMarks + "," + iotMarks + "," + cwsMarks + "," + esMarks + ")";
        st.executeUpdate(sql);
        System.out.println("student data added sucessfully");
        System.out.println("-------------------------------------------------------------");
    }

    static void deleteStudentData() throws Exception {
        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "");
        Statement st = con.createStatement();
        System.out.println("enter student enrollment number : ");
        long enrollmentNoForSearch = sc.nextLong();
        sc.nextLine();
        String sql = "delete from studentrecord where enrollmentNo=" + enrollmentNoForSearch + "";
        int r = st.executeUpdate(sql);
        System.out.println("Student's data has been deleted successfully");
        System.out.println("---------------------------------------------------------------");
    }

    static void viewStudnetData() throws Exception {

        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "");
        Statement st = con.createStatement();
        System.out.println("enter student enrollment number : ");
        long enrollmentNoForSearch = sc.nextLong();
        sc.nextLine();
        String sql = "select * from studentrecord where enrollmentNo=" + enrollmentNoForSearch + "";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {

            System.out.println("-----------------------------------------------------------");
            System.out.println("----------------------student details----------------------");
            System.out.println("-----------------------------------------------------------");
            System.out.println("student branch : " + rs.getString(1));
            System.out.println("student batch : " + rs.getString(2));
            System.out.println("student roll no : " + rs.getInt(3));
            System.out.println("student enrollment no : " + rs.getLong(4));
            System.out.println("student name : " + rs.getString(5));
            System.out.println("student maths marks : " + rs.getInt(6));
            System.out.println("student physcis theory marks : " + rs.getInt(7));
            System.out.println("student physcis practical marks : " + rs.getInt(8));
            System.out.println("student java theory marks : " + rs.getInt(9));
            System.out.println("student java practical marks : " + rs.getInt(10));
            System.out.println("student SE theory marks : " + rs.getInt(11));
            System.out.println("student SE practical marks : " + rs.getInt(12));
            System.out.println("student IOT marks : " + rs.getInt(13));
            System.out.println("student CWS marks : " + rs.getInt(14));
            System.out.println("student ES marks : " + rs.getInt(15));
        }
        System.out.println("-----------------------------------------------------------");
    }

    static String calculateGrades(double marks) {
        String grade = "";
        gradePoint = 0;
        if (marks >= 95.00 && marks <= 100.00) {
            grade = "O+++";
            gradePoint = 10;
        } else if (marks >= 90.00 && marks <= 94.99) {
            grade = "O++";
            gradePoint = 9.5;
        } else if (marks >= 85.00 && marks <= 89.99) {
            grade = "O+";
            gradePoint = 9;
        } else if (marks >= 80.00 && marks <= 84.99) {
            grade = "O";
            gradePoint = 8.5;
        } else if (marks >= 75.00 && marks <= 79.99) {
            grade = "A++";
            gradePoint = 8;
        } else if (marks >= 70.00 && marks <= 74.99) {
            grade = "A+";
            gradePoint = 7.5;
        } else if (marks >= 65.00 && marks <= 69.99) {
            grade = "A";
            gradePoint = 7;
        } else if (marks >= 60.00 && marks < 64.99) {
            grade = "B++";
            gradePoint = 6.5;
        } else if (marks >= 55.00 && marks <= 59.99) {
            grade = "B+";
            gradePoint = 6;
        } else if (marks >= 50.00 && marks <= 54.99) {
            grade = "B";
            gradePoint = 5.5;
        } else if (marks >= 45.00 && marks <= 49.99) {
            grade = "C";
            gradePoint = 5;
        } else if (marks >= 40.00 && marks <= 44.99) {
            grade = "D";
            gradePoint = 4.5;
        } else if (marks >= 35.00 && marks <= 39.99) {
            grade = "E";
            gradePoint = 4;
        } else if (marks >= 0.00 && marks <= 34.99) {
            grade = "F";
            gradePoint = 0;
        }
        return grade;
    }

    static String calculateOverAllGrades(double thMarks, double praMarks, double thCredit, double praCredit) {
        double marks = ((thMarks * thCredit) + (praMarks * praCredit)) / (thCredit + praCredit);
        String grade = "";
        if (marks >= 95.00 && marks <= 100.00) {
            grade = "O+++";
        } else if (marks >= 90.00 && marks <= 94.99) {
            grade = "O++";
        } else if (marks >= 85.00 && marks <= 89.99) {
            grade = "O+";
        } else if (marks >= 80.00 && marks <= 84.99) {
            grade = "O";
        } else if (marks >= 75.00 && marks <= 79.99) {
            grade = "A++";
        } else if (marks >= 70.00 && marks <= 74.99) {
            grade = "A+";
        } else if (marks >= 65.00 && marks <= 69.99) {
            grade = "A";
        } else if (marks >= 60.00 && marks < 64.99) {
            grade = "B++";
        } else if (marks >= 55.00 && marks <= 59.99) {
            grade = "B+";
        } else if (marks >= 50.00 && marks <= 54.99) {
            grade = "B";
        } else if (marks >= 45.00 && marks <= 49.99) {
            grade = "C";
        } else if (marks >= 40.00 && marks <= 44.99) {
            grade = "D";
        } else if (marks >= 35.00 && marks <= 39.99) {
            grade = "E";
        } else if (marks >= 0.00 && marks <= 34.99) {
            grade = "F";
        }
        return grade;
    }

    static String forSpace(String grade) {
        String printSpace = "";
        int length = grade.length();
        if (length == 4) {
            printSpace = "     ";
        } else if (length == 3) {
            printSpace = "      ";
        } else if (length == 2) {
            printSpace = "       ";
        } else if (length == 1) {
            printSpace = "        ";
        }
        return printSpace;
    }

    static String forEs(String grade) {
        String printGrade = "";
        String check = "F";
        if (grade.equals(check)) {
            printGrade = "FAIL   ";
        } else {
            printGrade = "PASS   ";
        }
        return printGrade;
    }

    static String result(String spi1) {
        double spi = Double.valueOf(spi1);
        String printResult = "";
        if (spi >= 7.00) {
            printResult = "First Class with Distinction                        ";
        } else if (spi >= 6.00 && spi <= 6.99) {
            printResult = "First Class                                         ";
        } else if (spi >= 5.50 && spi <= 5.99) {
            printResult = "Higher Second Class                                 ";
        } else if (spi >= 5.00 && spi <= 5.49) {
            printResult = "Second Class                                        ";
        } else if (spi >= 3.50 && spi <= 4.99) {
            printResult = "Pass Class                                          ";
        } else if (spi < 3.50) {
            printResult = "Fail                                                ";
        }
        return printResult;
    }

    static double calculateGradePoints() throws Exception {
        double gradePoints = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "");
        Statement st = con.createStatement();
        String sql = "select * from studentrecord where enrollmentNo=" + enrollmentNoForPrint + "";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            double mathsTotal = rs.getInt(6);
            double javaTotal = (rs.getInt(9) * 3 + rs.getInt(10) * 3) / 6;
            double seTotal = (rs.getInt(11) * 3 + rs.getInt(12) * 1) / 4;
            double physicsTotal = (rs.getInt(7) * 3 + rs.getInt(8) * 1) / 4;
            double iotTotal = rs.getInt(13);
            double cwsTotal = rs.getInt(14);
            calculateGrades(mathsTotal);
            gradePoints += gradePoint * 6;
            calculateGrades(javaTotal);
            gradePoints += gradePoint * 6;
            calculateGrades(physicsTotal);
            gradePoints += gradePoint * 4;
            calculateGrades(seTotal);
            gradePoints += gradePoint * 4;
            calculateGrades(iotTotal);
            gradePoints += gradePoint * 2;
            calculateGrades(cwsTotal);
            gradePoints += gradePoint * 2;
        }
        return gradePoints;
    }

    static void generateStudentMarksheet() throws Exception {
        Scanner sc = new Scanner(System.in);
        // Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "");
        Statement st = con.createStatement();
        System.out.println("enter student enrollment number : ");
        enrollmentNoForPrint = sc.nextLong();
        sc.nextLine();
        String sql = "select * from studentrecord where enrollmentNo=" + enrollmentNoForPrint + "";
        String fileName = Long.toString(enrollmentNoForPrint) + ".txt";
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            double earnedCredits = 24.0;
            bw.write(
                    "|-------------------------------------------------------------------------------------------------------|\n");
            bw.write(
                    "|                                     Lok Jagruti Kendra University                                     |\n");
            bw.write(
                    "|-------------------------------------------------------------------------------------------------------|\n");
            bw.write(
                    "|                                         Ahmedabad - 382210,INDIA                                      |\n");
            bw.write(
                    "|                               (Established by Gujarat Act No. 19 of 2019)                             |\n");
            bw.write(
                    "|-------------------------------------------------------------------------------------------------------|\n");
            bw.write(
                    "|                                                                                                       |\n");
            bw.write(
                    "|                                        Semester Performance Report                                    |\n");
            bw.write(
                    "|                                  LJ Institute of Engineering & Technology                             |\n");
            bw.write(
                    "|                                                                                                       |\n");
            bw.write(
                    "|-------------------------------------------------------------------------------------------------------|\n");
            bw.write(
                    "|                                                                                                       |\n");
            bw.write(
                    "|  Program : B.E/B.Tech                                                   Semester : 1                        |\n");
            bw.write("|  Enrollment no : " + rs.getLong(4) + "                                   "
                    + "Enrollment no(old) : -              |\n");
            bw.write("|  Name : " + rs.getString(5) + "                                    "
                    + "Medium of Instruction : English     |\n");
            bw.write(
                    "|                                                                                                       |\n");
            bw.write(
                    "|-------------------------------------------------------------------------------------------------------|\n");
            bw.write(
                    "|    Code    |            Course Title          | Credit | Theory grade | Practical grade |Overall grade|\n");
            bw.write("|  017121191 |  Mathematics-I                   |    6   |" + "      "
                    + calculateGrades(rs.getInt(6)) + forSpace(calculateGrades(rs.getInt(6))) + "         -         "
                    + "   " + calculateOverAllGrades(rs.getInt(6), 0, 6, 0)
                    + forSpace(calculateOverAllGrades(rs.getInt(6), 0, 6, 0)) + "|\n");
            bw.write("|  117122191 |  JAVA-I                          |    6   |" + "      "
                    + calculateGrades(rs.getInt(9)) + forSpace(calculateGrades(rs.getInt(9))) + "         "
                    + calculateGrades(rs.getInt(10)) + forSpace(calculateGrades(rs.getInt(10))) + "    "
                    + calculateOverAllGrades(rs.getInt(9), rs.getInt(10), 3, 3)
                    + forSpace(calculateOverAllGrades(rs.getInt(9), rs.getInt(10), 3, 3)) + "|\n");
            bw.write("|  017123191 |  Software Engineering            |    4   |" + "      "
                    + calculateGrades(rs.getInt(11)) + forSpace(calculateGrades(rs.getInt(11))) + "         "
                    + calculateGrades(rs.getInt(12)) + forSpace(calculateGrades(rs.getInt(12))) + "    "
                    + calculateOverAllGrades(rs.getInt(11), rs.getInt(12), 3, 1)
                    + forSpace(calculateOverAllGrades(rs.getInt(11), rs.getInt(12), 3, 1)) + "|\n");
            bw.write("|  017121192 |  Physics                         |    4   |" + "      "
                    + calculateGrades(rs.getInt(7)) + forSpace(calculateGrades(rs.getInt(7))) + "         "
                    + calculateGrades(rs.getInt(8)) + forSpace(calculateGrades(rs.getInt(8))) + "    "
                    + calculateOverAllGrades(rs.getInt(7), rs.getInt(8), 3, 1)
                    + forSpace(calculateOverAllGrades(rs.getInt(7), rs.getInt(8), 3, 1)) + "|\n");
            bw.write("|  017122192 |  IOT Workshop                    |    2   |" + "      -      " + "           "
                    + calculateGrades(rs.getInt(13)) + forSpace(calculateGrades(rs.getInt(13))) + "    "
                    + calculateOverAllGrades(0.0, rs.getInt(13), 0.0, 2)
                    + forSpace(calculateOverAllGrades(0.0, rs.getInt(13), 0.0, 2)) + "|\n");
            bw.write("|  017122193 |  Computer Workshop               |    2   |" + "      -      " + "           "
                    + calculateGrades(rs.getInt(14)) + forSpace(calculateGrades(rs.getInt(14))) + "    "
                    + calculateOverAllGrades(0.0, rs.getInt(14), 0.0, 2)
                    + forSpace(calculateOverAllGrades(0.0, rs.getInt(14), 0.0, 2)) + "|\n");
            bw.write("|  017128191 |  Environmental Science           |    0   |" + "      "
                    + calculateGrades(rs.getInt(15)) + forSpace(calculateGrades(rs.getInt(15))) + "         -         "
                    + "   " + forEs(calculateGrades(rs.getInt(15))) + "  " + "|\n");
            bw.write(
                    "|-------------------------------------------------------------------------------------------------------|\n");
            bw.write(
                    "|-------------------------------------------------------------------------------------------------------|\n");
            bw.write(
                    "|------------------------------- Semester Performace Index Report --------------------------------------|\n");
            bw.write(
                    "| Credits Offered : 24                                                                                  |\n");
            bw.write(
                    "| Credits Earned : 24                                                                                   |\n");
            bw.write("| Total Grade points earned : " + calculateGradePoints()
                    + "                                                                     |\n");
            bw.write(
                    "| SPI : Total Grade Points earned/ Total offered credits                                                |\n");
            String spi = String.format("%.2f", calculateGradePoints() / earnedCredits);
            String ppi = String.format("%.2f", calculateGradePoints() / earnedCredits);
            bw.write("| SPI : " + spi
                    + "                                                                                            |\n");
            bw.write(
                    "|                                                                                                       |\n");
            bw.write(
                    "|------------------------------- Progressive Performace Index Report -----------------------------------|\n");
            bw.write(
                    "|                                                                                                       |\n");
            bw.write(
                    "| PPI : Total Grade Points earned/ Total offered credits                                                |\n");
            bw.write("| PPI : " + ppi
                    + "                                                                                                      |\n");
            bw.write(
                    "|                                                                                                       |\n");
            bw.write(
                    "|-------------------------------------------------------------------------------------------------------|\n");
            bw.write("|                             You are Passed with : " + result(spi) + "|\n");
            bw.write(
                    "|                                                                                                       |\n");
            bw.write(
                    "|-------------------------------------------------------------------------------------------------------|\n");
            bw.close();
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("marksheet generated sucessfully see at your computer screen's left");
            System.out.println("----------------------------------------------------------------------------");
        }
    }

    public static void main(String[] args) throws Exception {

        Hashtable<String, Password> storePassword = new Hashtable<>();
        Scanner sc = new Scanner(System.in);
        storePassword.put("kirtiraj@gmail.com", new Password("Kirtiraj", "Admin@1234"));
        storePassword.put("milanthakkar1202@gmail.com", new Password("milan", "Admin@1234"));
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("------------------- welcome to marksheet generation system -------------------");
        System.out.println("-------------------------------------------------------------------------------");
        int choice;

        do {
            System.out.println("Please enter email id and password for login, for login press 1");
            System.out.println("for exit press 2");
            System.out.println("-------------------------------------------------------------------------------");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("enter email id :");
                    String emailForCheck = sc.nextLine();
                    if (storePassword.containsKey(emailForCheck)) {
                        Password forCheck = storePassword.get(emailForCheck);
                        String pass = forCheck.getPassword();
                        while (true) {
                            System.out.println("enter password : ");
                            String passwordForCheck = sc.nextLine();
                            if (passwordForCheck.equals(pass)) {
                                System.out.println("you have entered a right password");
                                System.out.println("------------------------------------------");
                                System.out.println("login sucessfully");
                                choice = 2;
                                break;
                            } else {
                                System.out.println("wrong password please try again");
                            }
                        }
                    } else {
                        System.out.println("email id not found");
                    }
                    break;

                case 2:
                    System.out.println("------------exiting-------------");
                    System.exit(0);
                    break;

                default:
                    System.out.println("invaild choice please try again");
                    break;
            }
        }

        while (choice != 2);
        int facultyChoice;
        do {
            System.out.println("enter 1 for add student marks to database");
            System.out.println("enter 2 to delete student's data");
            System.out.println("enter 3 for view any student marks from database");
            System.out.println("enter 4 for generate a marksheet");
            System.out.println("enter 5 for exit");
            facultyChoice = sc.nextInt();
            sc.nextLine();
            switch (facultyChoice) {
                case 1:
                    addstudentrecord();
                    break;

                case 2:
                    deleteStudentData();
                    break;

                case 3:
                    viewStudnetData();
                    break;

                case 4:
                    generateStudentMarksheet();
                    break;

                case 5:
                    System.out.println("---------------- exiting ----------------");
                    break;

                default:
                    System.out.println("invaild choice please try again");
            }
        } while (facultyChoice != 5);
        sc.close();
    }
}