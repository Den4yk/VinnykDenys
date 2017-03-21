package JSF;


import javax.faces.bean.ManagedBean;

@ManagedBean(name = "modifyjsf", eager = true)
public class ModifyJSF {

    public String getMessage() {
        return "Modify";
    }
}