package com.exercises;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    // Exercise 1: Mocking and Stubbing
    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }

    // Exercise 2: Verifying Interactions
    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
    }

    // Exercise 3: Argument Matching
    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.processData("testData");
        verify(mockApi).sendData(eq("testData"));
    }

    // Exercise 4: Handling Void Methods
    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doNothing().when(mockApi).sendData(anyString());
        MyService service = new MyService(mockApi);
        service.processData("hello");
        verify(mockApi).sendData("hello");
    }

    // Exercise 5: Multiple Return Values
    @Test
    public void testMultipleReturnValues() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("First Data")
                .thenReturn("Second Data");
        MyService service = new MyService(mockApi);
        assertEquals("First Data", service.fetchData());
        assertEquals("Second Data", service.fetchData());
    }

    // Exercise 6: Verifying Interaction Order
    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        service.processData("data");
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).sendData("data");
    }

    // Exercise 7: Void Methods with Exceptions
    @Test
    public void testVoidMethodWithException() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doThrow(new RuntimeException("Send failed"))
                .when(mockApi).sendData(anyString());
        MyService service = new MyService(mockApi);
        assertThrows(RuntimeException.class, () -> service.processData("data"));
    }
}
