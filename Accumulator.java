/**
 * Represent accumulating data from the elements in a List_inArraySlots that are
 * of a particular type.
 */

public class Accumulator {

  /**
   * @return the concatenation of all the Strings in the \list that begin with
   *         \prefix, each followed by a space.
   */
  public static String catElementsStartingWith(List_inArraySlots list, String prefix) {
    String result = "";

    for (int i = 0; i < list.size(); i++) {
      Object el = list.get(i);
      ((String)el).startsWith(prefix);
      if ( el instanceof String) {
        String str = (String) el;
        if (str.startsWith(prefix)) {
          result += str + " ";
        }
      }
    }

    /*
     * 3. Stumbling block 0 Java protects a programmer against applying a method to
     * elements in list when some elements of the list might omit support for a
     * particular operation.
     * 
     * This protection is implemented by the compiler. (compiler? JVM?) The
     * following code violates the restriction:
     */
    // el.startsWith(prefix);

    /*
     * predicted error message:
     * Error: Object does not have a startsWith method
     * actual error message:
     * error: cannot find symbol el.startsWith(prefix);
     */ 

    /*
     * 4. Workaround 0 A programmer should expect there to be a way to work around
     * the stumbling block, because the JVM (compiler? JVM?) knows the type
     * of an element.
     * 
     * Java's () operator identifies the type of an element to the
     * compiler(compiler? JVM?).
     */

    /*
     * 5. Stumbling block 1 However, use of the operator alone is insufficient,
     * because the JVM (compiler? JVM?) objects to the following code that
     * adds use of the operator to the code from Stumbling block 0:
     */

    // [code that illustrates the use of the operator]
    // ((String)el).startsWith(prefix);
    /*
     * predicted error message:
     * Can't cast this Object to a String
     * 
     * actual error message:
     * Exception in thread "main" java.lang.ClassCastException: class java.lang.Double cannot be cast to class java.lang.String
     */

    /*
     * 6. Workaround 1 Programmers use Java's instanceof operator to tell the
     * JVM (compiler? JVM?) that code uses a subclass's method on an object,
     * even though the reference to the object is stored in a super-class variable.
     */
    return result;
  }

  /**
   * @return a list of each of the Double elements from the \list whose value is
   *         "finite".
   */
  public static List_inArraySlots finites(List_inArraySlots list) {
    List_inArraySlots result = new List_inArraySlots();
    for(int i = 0; i < list.size(); i++) {
      Object element = list.get(i);
      if (element instanceof Double) {
        if (!((Double)element).isInfinite()) {
          result.add(element);
        }
      }
    }
    return result;
  }
}
