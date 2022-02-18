package Farzan;

/**
 * implementing students and teachers with array list
 */
public record School(CustomArrList<Teacher> teachers, CustomArrList<Student> students) {
    private static long total_funds_Earned;
    private static long total_funds_Spent;

    public School(CustomArrList<Teacher> teachers, CustomArrList<Student> students) {
        this.teachers = teachers;
        this.students = students;
        total_funds_Earned = 0;
        total_funds_Spent = 0;
    }

    public long getTotal_funds_Earned() {
        return total_funds_Earned;
    }

    public static void UpdateTotal_funds_Earned(long total_funds_Earned) {
        School.total_funds_Earned += total_funds_Earned;
    }


    public long getTotal_funds_Spent() {
        return total_funds_Spent;
    }

    public static void UpdateTotal_funds_Spent(long total_funds_Spent) {
        School.total_funds_Earned -= total_funds_Spent;
    }
}
