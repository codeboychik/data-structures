import java.util.ArrayList;
import java.util.List;
// n = 1 ->> ()
// n = 2 ->> ()(), (())
// n = 3 ->> ()()(), ((())), (())(), (()()), ()(())
// result: ()()(), ()(()), (()()), (())()
// {}[]() ->> {}[(]) ->> {}([]) ->> {(}[]) ->> ({}[]) ->> ({}[)] ->> ({})[] ->> ({)}[] ->> (){}[] ({[]})
public class GenerateParentheses {
    public static List<String> generateParentheses(int n) {
        String parentheses = "(".repeat(n) + ")".repeat(n);
        List<String> result = new ArrayList<>();
        for (int pairs = n; pairs > 0; pairs--) {

        }
        return result;
    }
    // forward(abcd) ->> abdc
    public static String forward(String a, String toMove) {

        int len = a.substring(toMove);
        String before = a.substring(0, pos);
        String lastBefore = String.valueOf(before.charAt(before.length() - 1));
        String after = a.substring(pos + 1);
        a = a.substring(0, pos - 1) + toMove + lastBefore + after;
        return a;
    }

    public static void main(String[] args) {
        String parentheses = "()()";
        String a = "()()";
        a = forward(a, "()");
        System.out.println(a);
        a = forward(a, "()");
        System.out.println(a);
    }
}
