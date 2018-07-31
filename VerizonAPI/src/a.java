import java.net.URL;
import java.net.URLClassLoader;

public class a {
	public static void main(String args[]) {

		ClassLoader cl = ClassLoader.getSystemClassLoader();

		URL[] urls = ((URLClassLoader) cl).getURLs();
		System.out.println(cl.getParent());
		for (URL url : urls) {
			System.out.println("1" + url.getPath() + "\n");
			// System.out.println(url.getFile());
		}

	}
}
