package it.beije.neumann.mercuri.rubrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {

    private final static int MAX_CONNECTIONS = 10;
    private static ConnectionPool instance = null;  
    private static Connection[] connections = new Connection[MAX_CONNECTIONS];
    private static String dbUrl = "jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false";
    private static int counter;

    private ConnectionPool() { }

    public static ConnectionPool getInstance() {

            if(instance == null) {
                instance = new ConnectionPool();
                initializeConnections();
                counter = 0;
            }

        return instance;
    }

    private static void initializeConnections() {
        for(int i = 0; i < MAX_CONNECTIONS; i++) {
            try {
                connections[i] = DriverManager.getConnection(dbUrl, "root", "*****");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        counter++;
        if(counter == Integer.MAX_VALUE)
            counter = 0;

        return connections[counter%MAX_CONNECTIONS];
    }

}