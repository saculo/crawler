package org.saculo.crawler.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseConnector {
    private final String username;
    private final String password;
    private final String url;

    DatabaseConnector () {
        this.username = "sa";
        this.password = "";
        this.url = "jdbc:h2:~/test";
    }

    Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
