package edu.uiuc.ncsa.security.util.functor.strings;

import edu.uiuc.ncsa.security.util.functor.JFunctor;
import edu.uiuc.ncsa.security.util.functor.JFunctorImpl;

/**
 * <p>Created by Jeff Gaynor<br>
 * on 3/1/18 at  1:35 PM
 */
public class jToUpperCase extends JFunctorImpl {
    public jToUpperCase() {
        super("$toUpperCase");
    }

    @Override
    public Object execute() {
        if (getArgs().size() != 1) {
            throw new IllegalStateException("Error: this functor requires a single argument");
        }
        Object obj = getArgs().get(0);
        String x = null;
        if (obj instanceof JFunctor) {
            JFunctor ff = (JFunctor) obj;
            ff.execute();
            x = String.valueOf(ff.getResult());
        } else {
            x = String.valueOf(obj);
        }
        result = x.toUpperCase();
        return result;
    }
}
