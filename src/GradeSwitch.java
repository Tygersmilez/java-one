 import java.util.Scanner;

    public class GradeSwitch {
        public static void main(String[] args) {
            // cal average = total/counter
            // output grade according to ABCDF
            // COUNT of each ABCDF grade entered.

            int total = 0;
            int gradeCounter = 0;
            int aCount = 0;
            int bCount = 0;
            int cCount = 0;
            int dCount = 0;
            int fCount = 0;

            Scanner input = new Scanner(System.in);

            System.out.printf("%s%n%s%n %s%n %s%n",
                    "Enter the integer grades in the range 0-100.",
                    "Type the end-of-file indicator to terminate input:",
                    "On UNIX/Linux/Mac OS X type <Ctrl> d then press Enter",
                    "On Windows type <Ctrl> z then press Enter");

            while (input.hasNextInt()) {
                int grade = input.nextInt();
                total = total + grade;
                ++gradeCounter;

                //100-90 A, - 9, 10
                //89-80 B,- 8
                //79-70 C, - 7
                //69-60 D, -6
                //59 < F. DEFAULT
                //for(){}
                //traditional switch
                if (grade > 100) {
                    System.out.println("grades must be between 0 and 100");
                }
               
                switch (grade / 10) {
                    case 9:
                    case 10:
                        ++aCount;
                        break;
                    case 8:
                        ++bCount;
                        break;
                    case 7:
                        ++cCount;
                        break;
                    case 6:
                        ++dCount;
                        break;
                    default:
                        ++fCount;
                        break;
                }

                //advance switch case
                switch (grade / 10) {
                    case 10, 9 -> ++aCount;
                    case 8 -> ++bCount;
                    case 7 -> ++cCount;
                    case 6 -> ++dCount;
                    default -> ++fCount;

                }
            }

            if (gradeCounter != 0) {
                // casting double to int and promoting int to double 0.9
                double average = (double) total / gradeCounter;
                System.out.printf("%nAverage grade: %.2f%n", average);
                System.out.printf("Total of the %d grades entered is %d%n", gradeCounter, total);
                System.out.printf("Class average is %.2f%n", average);
                // calculate average of all grades entered
                System.out.printf("%n%s%n%s%d%n%s%d%n%s%d%n%s%d%n%s%d%n", "Number of students who received each grade:",
                        "A: ", aCount,
                        "B: ", bCount,
                        "C: ", cCount,
                        "D: ", dCount,
                        "F: ", fCount);
            } else {
                System.out.println("No grades were entered");
            }
        }
    }
