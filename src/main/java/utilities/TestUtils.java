package utilities;

import java.time.Instant;

public class TestUtils {
	public static String uniqueEmail(String base) {
        return base.replace("@", "+" + Instant.now().toEpochMilli() + "@");
    }

}
