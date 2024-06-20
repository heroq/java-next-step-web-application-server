package webserver;

import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RequestListTest {

	@Mock
	private RequestList requestList;

	@Test
	void index() throws IOException {
		// Given
		DataOutputStream dos = new DataOutputStream(new ByteArrayOutputStream());
		HashMap<String, String> cookie = new HashMap<>();
		HashMap<String, String> requestMap = new HashMap<>();

		doNothing().when(requestList).index(any(HashMap.class), any(HashMap.class), any(DataOutputStream.class));

		// When
		requestList.index(cookie, requestMap, dos);

		// Then
		verify(requestList).index(cookie, requestMap, dos);
	}

	@Test
	void createUser() {
	}

	@Test
	void login() {
	}

	@Test
	void list() {
	}
}