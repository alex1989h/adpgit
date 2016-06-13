package aufgabenblatt7;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeblogTest {

	@Test
	public void testErtelleWeblog() {
		Weblog.erstelleWeblog("weblog.txt", 20);
	}

}
