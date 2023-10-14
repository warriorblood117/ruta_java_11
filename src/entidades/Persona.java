package entidades;

public class Persona {

    private String document;//ID

    private String name;

    private String lastname;

    private String phoneNumber;

    private int age;

    private String mail;

    public Persona(String document, String name, String lastname, String phoneNumber, int age, String mail) {
        this.document = document;
        this.name = name;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "document='" + document + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", mail='" + mail + '\'' +
                '}';
    }
}

