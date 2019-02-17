import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @author andyFan
 * @date 2018年12月11日  17:50:51
 */
public class TestPrivilegedAction implements PrivilegedAction {
    @Override
    public Object run() {
        AccessController.checkPermission(new PersonnelPermission("access"));
        System.out.println("\nYour user.home property value is: "
                + System.getProperty("user.home"));
        return "";
    }
}
