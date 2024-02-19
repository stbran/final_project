package ru.sbertroika.service_for_db.TMS;

public class DBConfig {
    private static final String BD_LOGIN = "postgres";
    private static final String BD_PASS = "postgres";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/tms_db";


    public static String getBdLogin() {
        return BD_LOGIN;
    }

    public static String getBdPass() {
        return BD_PASS;
    }

    public static String getDbUrl() {
        return DB_URL;
    }
}
