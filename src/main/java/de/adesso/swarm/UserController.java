package de.adesso.swarm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserController {
    static UserRepository repo = SwarmApplication.getGlobal_repository();
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public static void createUser() {
        createUser("N/A");
    }

    public static void createUser(String _lastName) {
        createUser("N/A", _lastName);
    }

    public static void createUser(UGroup _userGroup) {
        createUser("N/A", "N/A", _userGroup);
    }

    public static void createUser(String _firstName, String _lastName) {
        createUser(_firstName, _lastName, UGroup.DUMMY);
    }

    public static void createUser(String _firstName, String _lastName, UGroup _userGroup) {
        User temp;
        repo.save(temp = new User(_firstName, _lastName, _userGroup));
        log.info(temp + "created.");
    }
}
