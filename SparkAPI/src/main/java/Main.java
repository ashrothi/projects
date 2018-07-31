import static spark.Spark.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {

		Map<String, String> result = new LinkedHashMap<>();
		result.put("hello", "java");
		get("/hello", (req, res) -> result);

		post("/hello", (req, res) -> result);

	}
}