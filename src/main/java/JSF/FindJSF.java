package JSF;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "findjsf", eager = true)
public class FindJSF {

    public String getMessage() {
        return "Find";
    }
}
