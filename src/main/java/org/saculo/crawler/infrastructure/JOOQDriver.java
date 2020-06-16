package org.saculo.crawler.infrastructure;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.SQLException;

public class JOOQDriver {
    private static final DatabaseConnector databaseConnector = new DatabaseConnector();

    public static DSLContext createContext() {
        try {
            return DSL.using(databaseConnector.connect(), SQLDialect.H2);
        }
        catch (SQLException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
