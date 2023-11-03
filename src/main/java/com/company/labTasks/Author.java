package com.company.labTasks;
public class Author
{
    private String firstName;
    private String secondName;
    private int id;

    @Override
    public String toString() {
        return Integer.toString(getId()) + "\t" + getFirstName() +"\t"+ getSecondName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}