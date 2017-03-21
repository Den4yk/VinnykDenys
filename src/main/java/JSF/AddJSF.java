package JSF;


import javax.faces.bean.ManagedBean;

@ManagedBean(name = "addjsf", eager = true)
public class AddJSF {

    public String getMessage() {
        return "Add";
    }
}
