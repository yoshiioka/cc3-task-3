import java.util.*;

public class Student {
    // Private attributes to prevent "leaks" 
    private String SURNAME, FIRSTNAME, MIDDLENAME, GENDER, BIRTHMONTH, COURSE;
    private int AGE, BIRTHYEAR, STUDENTID, YEAR;

    private Student(Builder builder) {
        this.SURNAME = builder.SURNAME;
        this.FIRSTNAME = builder.FIRSTNAME;
        this.MIDDLENAME = builder.MIDDLENAME;
        this.AGE = builder.AGE;
        this.GENDER = builder.GENDER;
        this.BIRTHMONTH = builder.BIRTHMONTH;
        this.BIRTHYEAR = builder.BIRTHYEAR;
        this.STUDENTID = builder.STUDENTID;
        this.COURSE = builder.COURSE;
        this.YEAR = builder.YEAR;
    }

    // Getters as defined in your diagram 
    public String getSurname() { return SURNAME; }
    public String getFirstName() { return FIRSTNAME; }
    public String getMiddleName() { return MIDDLENAME; }
    public int getAge() { return AGE; }
    public String getGender() { return GENDER; }
    public String getBirthMonth() { return BIRTHMONTH; }
    public int getBirthYear() { return BIRTHYEAR; }
    public int getStudentId() { return STUDENTID; }
    public String getCourse() { return COURSE; }
    public int getYear() { return YEAR; }

    public static class Builder {
        private String SURNAME, FIRSTNAME, MIDDLENAME, GENDER, BIRTHMONTH, COURSE;
        private int AGE, BIRTHYEAR, STUDENTID, YEAR;

        public Builder setSurname(String s) { this.SURNAME = s; return this; }
        public Builder setFirstName(String f) { this.FIRSTNAME = f; return this; }
        public Builder setMiddleName(String m) { this.MIDDLENAME = m; return this; }
        public Builder setAge(int a) { this.AGE = a; return this; }
        public Builder setGender(String g) { this.GENDER = g; return this; }
        public Builder setBirthMonth(String bm) { this.BIRTHMONTH = bm; return this; }
        public Builder setBirthYear(int by) { this.BIRTHYEAR = by; return this; }
        public Builder setStudentId(int id) { this.STUDENTID = id; return this; }
        public Builder setCourse(String c) { this.COURSE = c; return this; }
        public Builder setYear(int y) { this.YEAR = y; return this; }

        public Student build() { return new Student(this); }
    }
}
