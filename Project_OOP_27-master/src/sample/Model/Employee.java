package sample.Model;

public class Employee {

    protected String type;
    private String name;
    private String cmt;
    private String department;
    private String time_start;

    public Employee(String name, String cmt, String department, String time_start){
        this.name = name;
        this.cmt = cmt;
        this.department = department;
        this.time_start = time_start;
    }

    public void info() {
        System.out.println("----- Information of Employee " + name + " -----");
        System.out.println("Name: " + name);
        System.out.println("CMT: " + cmt);
        System.out.println("Department: " + department);
        System.out.println("Time Start: " + time_start);
    }

    public String getName() {
        return name;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}




