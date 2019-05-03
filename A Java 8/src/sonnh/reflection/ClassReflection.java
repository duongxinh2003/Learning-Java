package sonnh.reflection;

import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

public class ClassReflection {

  public static void main(String[] args) {
    // Print the class declaration for the Person class
    String classDescription = getClassDescription(Person.class);
    System.out.println(classDescription);
  }

  public static String getClassDescription(Class<Person> c) {
    StringBuilder classDesc = new StringBuilder();

    // Prepare the modifiers and construct keyword(class, enum, interface,...)
    int modifierBits = 0;
    String keyword = "";

    // Add keyword @interface, interface or class
    if (c.isPrimitive()) {
      // do not want to add any thing
    } else if (c.isInterface()) {
      modifierBits = c.getModifiers() & Modifier.interfaceModifiers();

      // An annotation is an interface
      if (c.isAnnotation()) {
        keyword = "@interface";
      } else {
        keyword = "interface";
      }
    } else if (c.isEnum()) {
      modifierBits = c.getModifiers() & Modifier.classModifiers();
      keyword = "enum";
    } else {
      modifierBits = c.getModifiers() & Modifier.classModifiers();
      keyword = "class";
    }

    // Convert modifiers to their string representation
    String modifiers = Modifier.toString(modifierBits);

    // Append modifiers
    classDesc.append(modifiers);

    // Append the construct keyword
    classDesc.append(" " + keyword);

    // Append simple name
    String simpleName = c.getSimpleName();
    classDesc.append(" " + simpleName);

    // Append generic parameters
    String genericParams = getGenericTypeParams(c);
    classDesc.append(genericParams);

    // Append super class
    Class<?> superClass = c.getSuperclass();
    if (superClass != null) {
      String superClassSimpleName = superClass.getSimpleName();
      classDesc.append(" extends " + superClassSimpleName);
    }

    // Append Interfaces
    String interfaces = ClassReflection.getClassInterfaces(c);
    if (interfaces != null) {
      classDesc.append(" implements " + interfaces);
    }
    return classDesc.toString();
  }

  public static String getClassInterfaces(Class<Person> c) {
    // Get a comma-separated list of interfaces implemented by the class
    Class<?>[] interfaces = c.getInterfaces();
    String interfaceList = null;
    if (interfaces.length > 0) {
      String[] interfaceNames = new String[interfaces.length];
      for (int i = 0; i < interfaceNames.length; i++) {
        interfaceNames[i] = interfaces[i].getSimpleName();
      }
      interfaceList = String.join(", ", interfaceNames);
    }
    return interfaceList;
  }

  public static String getGenericTypeParams(Class<Person> c) {
    StringBuilder sb = new StringBuilder();
    TypeVariable<?>[] typeParams = c.getTypeParameters();

    if (typeParams.length > 0) {
      String[] paramNames = new String[typeParams.length];
      for (int i = 0; i < typeParams.length; i++) {
        paramNames[i] = typeParams[i].getName();
      }

      sb.append('<');
      String paramList = String.join(",", paramNames);
      sb.append(paramList);
      sb.append('>');
    }
    return sb.toString();
  }
}
