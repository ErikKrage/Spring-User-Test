package de.adesso.swarm;

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
    private Long companyAdminId;

    public Company() {
        this("N/A");
    }

    public Company(String _name) {
        this(_name, "N/A");
    }

    public Company(String _name, String _domain) {
        this(_name, _domain, 1L);
    }

    public Company(String _name, String _domain, Long _adminId) {
        changeName(_name);
        changeDomain(_domain);
        changeAdmin(_adminId);
    }

    public void changeName(String _name) {
        name = _name;
    }

    public void changeDomain(String _domain) {
        domain = _domain;
    }

    public User getUserById(Long _id) {
        return _id == null ? SwarmApplication.getGlobalUserRepository()
                .save(new User("Admin Dummy", "Company: " + name, UGroup.DUMMY))
                : SwarmApplication.getGlobalUserRepository().findById(_id).get();
    }

    public User getAdmin() {
        return getUserById(companyAdminId);
    }

    public void changeAdmin(Long _id) {
        /*if (_user.getUserGroup() != UGroup.COM_ADMIN &&
                _user.getUserGroup() != UGroup.SYS_ADMIN &&
                _user.getUserGroup() != UGroup.PRODUCT_OWNER)
            _user.setUserGroup(UGroup.COM_ADMIN);*/
        companyAdminId = _id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Long getCompanyAdminId() {
        return companyAdminId;
    }

    public void setCompanyAdminId(Long companyAdminId) {
        this.companyAdminId = companyAdminId;
    }
}
