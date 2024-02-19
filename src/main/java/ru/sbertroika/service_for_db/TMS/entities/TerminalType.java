package ru.sbertroika.service_for_db.TMS.entities;

import java.util.UUID;

public class TerminalType {
    private UUID id;
    private String name;

    public TerminalType(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
