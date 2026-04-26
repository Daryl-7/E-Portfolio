package mypackage;
import java.util.Scanner;

public class EnrollmentAssessmentSystemAlidro {
    static String name, strand, sresult;
    static int cstrand, screening;
    static boolean validInput = false;
    static double escore, iscore, finalresult;
    static Scanner input = new Scanner(System.in);

    public static void setStudentName() {
        System.out.println("==== ENROLLMENT ASSESSMENT SYSTEM ====");
        System.out.print("\nStudent Name: ");
        name = input.nextLine();
    }

    public static String getStudentName() {
        return name;
    }

    public static void setStrand() {
        do {
            System.out.println("\n(1. STEM  2. ABM  3. HUMSS  4. TVL  5. Others)");
            System.out.print("Strand: ");
            cstrand = input.nextInt();

            switch (cstrand) {
                case 1:
                    strand = "STEM";
                    validInput = true;
                    break;
                case 2:
                    strand = "ABM";
                    validInput = true;
                    break;
                case 3:
                    strand = "HUMSS";
                    validInput = true;
                    break;
                case 4:
                    strand = "TVL";
                    validInput = true;
                    break;
                case 5:
                    System.out.print("Input strand: ");
                    strand = input.next();
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid Input. Try Again.");
            }
        } while (!validInput);
    }

    public static String getStrand() {
        return strand;
    }

    public static void setEntranceScore() {
        do {
            System.out.print("\nEntrance Exam Score (0-100): ");
            escore = input.nextDouble();

            if (escore < 0 || escore > 100) {
                System.out.println("Invalid Input. Try Again.");
            } else {
                break;
            }
        } while (true);
    }

    public static double getEntranceScore() {
        return escore;
    }

    public static void setInterviewScore() {
        do {
            System.out.print("Interview Score (0-100): ");
            iscore = input.nextDouble();

            if (iscore < 0 || iscore > 100) {
                System.out.println("Invalid Input. Try Again.");
            } else {
                break;
            }
        } while (true);
    }

    public static double getInterviewScore() {
        return iscore;
    }

    public static void setScreeningResult() {
        validInput = false;
        do {
        	System.out.println("\n(1. Pass  2. Fail)");
            System.out.print("First Screening Result:  ");
            screening = input.nextInt();

            switch (screening) {
                case 1:
                    sresult = "Pass";
                    validInput = true;
                    break;
                case 2:
                    sresult = "Fail";
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid Input. Try Again.");
            }
        } while (!validInput);
    }

    public static double FinalEvaluationScore(double escore, double iscore) {
        return (escore * 0.60) + (iscore * 0.40);
    }

    public static String getAdmissionResult() {
        if (screening == 1) {
            if (finalresult >= 85) {
                return "Admitted with Scholarship!";
            } else if (finalresult >= 75) {
                return "Admitted";
            } else if (finalresult >= 65) {
                return "Waitlisted";
            } else {
                return "Failed";
            }
        } else {
            return "Failed";
        }
    }

    public static String getRecommendedProgram() {
        switch (strand) {
            case "STEM":
                return "BSIT / BSCS";
            case "ABM":
                return "BSBA";
            case "HUMSS":
                return "BSED / AB Communication";
            case "TVL":
                return "BSIT";
            default:
                return "General Program";
        }
    }

    public static void main(String[] args) {

        setStudentName();
        setStrand();
        setEntranceScore();
        setInterviewScore();
        setScreeningResult();

        finalresult = FinalEvaluationScore(getEntranceScore(), getInterviewScore());

        System.out.println("\n===== ENROLLMENT ASSESSMENT RESULT =====");
        System.out.println();
        System.out.println("Student Name:           " + getStudentName());
        System.out.println("SHS Strand:             " + getStrand());
        System.out.printf("Final Evaluation Score: %.2f%n", finalresult);
        System.out.println("Admission Result:       " + getAdmissionResult());
        System.out.println("Recommended Program:    " + getRecommendedProgram());
        System.out.println();
        System.out.println("=========================================");
    }
}
