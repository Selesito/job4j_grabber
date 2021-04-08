package ru.job4j.tdd;

import javax.xml.crypto.Data;
import java.sql.DatabaseMetaData;

public interface Ticket {

    Session getSession();

    Data getData();
}
