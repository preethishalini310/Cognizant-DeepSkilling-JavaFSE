package com.exercises;
public class NetworkService {
    private final NetworkClient networkClient;
    public NetworkService(NetworkClient c) { networkClient = c; }
    public String connectToServer() { return "Connected to " + networkClient.connect(); }
}
