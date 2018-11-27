package de.adesso.swarm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int memberCount;
    private String domain;
    private User companyAdmin;

    public Company(){
        this("N/A");
    }

    public Company(String _name){
        this(_name, "N/A");
    }

    public Company(String _name, String _domain){
        changeName(_name);
        changeDomain(_domain);
    }

    public void changeName(String _name){
        name = _name;
    }

    public void changeDomain(String _domain){
        domain = _domain;
    }

    public void changeAdmin(User _user){
        if (_user.getUserGroup() != UGroup.COM_ADMIN &&
                _user.getUserGroup() != UGroup.SYS_ADMIN &&
                _user.getUserGroup() != UGroup.PRODUCT_OWNER)
            _user.setUserGroup(UGroup.COM_ADMIN);
        companyAdmin = _user;
    }
}
