public class Student {
    private final String SURNAME;
    private final String FIRSTNAME;
    private final String MIDDLENAME;
    private final int AGE;
    private final String GENDER;
    private final String BIRTHMONTH;
    private final int BIRTHYEAR;
    private final int STUDENTID;
    private final String COURSE;
    private final int YEAR;

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


    private Student(Builder builder){
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

    public static class Builder {
        private  String SURNAME;
        private  String FIRSTNAME;
        private  String MIDDLENAME;
        private  int AGE;
        private  String GENDER;
        private  String BIRTHMONTH;
        private  int BIRTHYEAR;
        private  int STUDENTID;
        private  String COURSE;
        private  int YEAR;

        public Builder setSurname(String surname) {
            this.SURNAME = surname;
            return this;
        }
        public Builder setFirstName(String firstName) {
            this.FIRSTNAME = firstName;
            return this;
        }
        public Builder setMiddleName(String middleName) {
            this.MIDDLENAME = middleName;
            return this;
        }
        public Builder setAge(int age) {
            this.AGE = age;
            return this;
        }
        public Builder setGender(String gender) {
            this.GENDER = gender;
            return this;
        }
        public Builder setBirthMonth(String birthMonth) {
            this.BIRTHMONTH = birthMonth;
            return this;
        }
        public Builder setBirthYear(int birthYear) {
            this.BIRTHYEAR = birthYear;
            return this;
        }
        public Builder setStudentID(int studentID) {
            this.STUDENTID = studentID;
            return this;
        }
        public Builder setCourse(String course) {
            this.COURSE = course;
            return this;
        }
        public Builder setYear(int year) {
            this.YEAR = year;
            return this;
        }
        public Student build(){
            return new Student(this);
        }
    }
}
