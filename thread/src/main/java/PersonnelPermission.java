import java.security.BasicPermission;

/**
 * @author andyFan
 * @date 2018年12月11日  17:47:05
 */
public class PersonnelPermission extends BasicPermission {

    private static final long serialVersionUID = -3907398941038069753L;
    public PersonnelPermission(String name) {
        super(name);

    }
    public PersonnelPermission(String name, String action) {
        super(name);
    }
}
