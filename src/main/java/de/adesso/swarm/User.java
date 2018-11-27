package de.adesso.swarm;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private UGroup userGroup;

    @Transient
    private final String OUTPUT_FORMAT = "USER #%d: %s, %s (%s)";

    public User() {
        this("N/A", "N/A");
    }

    public User(String _firstName, String _lastName) {
        this(_firstName, _lastName, UGroup.DUMMY);
    }

    public User(String _firstName, String _lastName, UGroup _userGroup) {
        firstName = _firstName;
        lastName = _lastName;
        userGroup = _userGroup;
    }

    @Override
    public String toString() {
        return String.format(OUTPUT_FORMAT, id, lastName, firstName, userGroup);
    }

    public Long getId(){
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UGroup userGroup) {
        this.userGroup = userGroup;
    }
}
