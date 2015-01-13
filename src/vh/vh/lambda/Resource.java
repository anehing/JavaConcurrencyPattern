package vh.vh.lambda;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by ane on 1/9/15.
 */
public class Resource {
    private Resource() {
       // System.out.println("Opening resource");
    }

    public void operate() {
        System.out.println("Operating on resource");
    }

    public void dispose() {
        System.out.println("Disposing resource");
    }

    public static void withResource(Consumer<Resource> consumer) {
        Resource resource = new Resource();
        try {
            consumer.accept(resource);
        } finally {
           // resource.dispose();
        }
    }
    public static void withResource2(Predicate<Resource> predicate) {
        Resource resource = new Resource();
        try {
            predicate.test(resource);
        } finally {
            // resource.dispose();
        }
    }
}
