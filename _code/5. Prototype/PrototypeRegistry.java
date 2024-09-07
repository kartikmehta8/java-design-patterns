import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {
    private Map<String, Shape> shapeRegistry = new HashMap<>();

    public void registerShape(String key, Shape shape) {
        shapeRegistry.put(key, shape);
    }

    public Shape getShape(String key) {
        Shape prototype = shapeRegistry.get(key);
        return prototype.clone();
    }
}
