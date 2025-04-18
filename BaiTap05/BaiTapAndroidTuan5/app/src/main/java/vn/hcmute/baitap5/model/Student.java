package vn.hcmute.baitap5.model;

public class Student {
    private String id;
    private String email;
    private  String name;
    private String address;
    private String phone;

    public Student(String email, String name, String address, String phone) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        if(!id.matches("\\d{6}")){
            throw new IllegalArgumentException("ID must have 6 digital");
        }
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }
}
