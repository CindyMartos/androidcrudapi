package models;

/**
 * Created by ludk on 10/10/15.
 */
public class Contact {

    public String Name;

    public String Phone;

    public String Photo;

    public Contact() {}

    public Contact(String name, String phone, String photo) {
        Name = name;
        Phone = phone;
        Photo = photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }
}
