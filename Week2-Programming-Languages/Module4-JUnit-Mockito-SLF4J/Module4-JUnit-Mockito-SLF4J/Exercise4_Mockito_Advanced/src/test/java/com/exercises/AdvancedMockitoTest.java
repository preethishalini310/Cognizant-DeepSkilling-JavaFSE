package com.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AdvancedMockitoTest {

    // Exercise 1: Mocking Databases and Repositories
    @Test
    public void testServiceWithMockRepository() {
        Repository mockRepository = mock(Repository.class);
        when(mockRepository.getData()).thenReturn("Mock Data");
        Service service = new Service(mockRepository);
        String result = service.processData();
        assertEquals("Processed Mock Data", result);
    }

    // Exercise 2: Mocking External Services (RESTful APIs)
    @Test
    public void testServiceWithMockRestClient() {
        RestClient mockRestClient = mock(RestClient.class);
        when(mockRestClient.getResponse()).thenReturn("Mock Response");
        ApiService apiService = new ApiService(mockRestClient);
        String result = apiService.fetchData();
        assertEquals("Fetched Mock Response", result);
    }

    // Exercise 3: Mocking File I/O
    @Test
    public void testServiceWithMockFileIO() {
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);
        when(mockFileReader.read()).thenReturn("Mock File Content");
        FileService fileService = new FileService(mockFileReader, mockFileWriter);
        String result = fileService.processFile();
        assertEquals("Processed Mock File Content", result);
    }

    // Exercise 4: Mocking Network Interactions
    @Test
    public void testServiceWithMockNetworkClient() {
        NetworkClient mockNetworkClient = mock(NetworkClient.class);
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");
        NetworkService networkService = new NetworkService(mockNetworkClient);
        String result = networkService.connectToServer();
        assertEquals("Connected to Mock Connection", result);
    }

    // Exercise 5: Mocking Multiple Return Values
    @Test
    public void testServiceWithMultipleReturnValues() {
        Repository mockRepository = mock(Repository.class);
        when(mockRepository.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");
        Service service = new Service(mockRepository);
        assertEquals("Processed First Mock Data", service.processData());
        assertEquals("Processed Second Mock Data", service.processData());
    }
}
