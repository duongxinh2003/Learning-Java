package sonnh.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class ExecutableUtil {
  public static ArrayList<String> getPrameter(Executable exec) {
    Parameter[] params = exec.getParameters();
    ArrayList<String> paramList = new ArrayList<>();
    for (int i = 0; i < params.length; i++) {
      // Get modifiers, type, and name of the parameter
      int mod = params[i].getModifiers() & Modifier.parameterModifiers();
      String modifiers = Modifier.toString(mod);
      String paramType = params[i].getType().getSimpleName();
      String paramName = params[i].getName();
      String temp = modifiers + " " + paramType + " " + paramName;

      // Trim it as it may have leading spaces when modifiers are absent
      paramList.add(temp.trim());
    }
    return paramList;
  }

  public static ArrayList<String> getExceptionList(Executable exec) {
    ArrayList<String> exceptionList = new ArrayList<>();
    for (Class<?> c : exec.getExceptionTypes()) {
      exceptionList.add(c.getSimpleName());
    }
    return exceptionList;
  }

  public static String getThrowsClause(Executable exec) {
    ArrayList<String> exceptionList = new ArrayList<>();
    String exceptions = ExecutableUtil.arrayListToString(exceptionList, ",");
    String throwClause = "";
    if (exceptionList.size() > 0) {
      throwClause = "throws " + exceptions;
    }

    return throwClause;
  }

  public static String getModifiers(Executable exec) {
    // Get the modifiers for the class
    int mod = exec.getModifiers();
    if (exec instanceof Method) {
      mod = mod & Modifier.methodModifiers();
    } else if (exec instanceof Constructor) {
      mod = mod & Modifier.classModifiers();
    }
    return Modifier.toString(mod);
  }

  public static String arrayListToString(ArrayList<String> list, String separator) {
    String[] tempArray = new String[list.size()];
    tempArray = list.toArray(tempArray);
    String str = String.join(separator, tempArray);
    return str;
  }
}
