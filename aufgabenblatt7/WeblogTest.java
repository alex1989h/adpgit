package aufgabenblatt7;

import org.junit.Test;

public class WeblogTest {

	@Test
	public void testErtelleWeblog() {
		Weblog.erstelleWeblog("weblog.txt", (int)5E6);
	}

}
