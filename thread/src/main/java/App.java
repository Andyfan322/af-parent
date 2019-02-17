import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Hello world!
 */
public class App implements PrivilegedAction {
    @Override
    public Object run() {
        AccessController.checkPermission(new PersonnelPermission("access"));
        System.out.println("\nYour user.home property value is: "
                + System.getProperty("user.home"));
        return "";
    }
}
