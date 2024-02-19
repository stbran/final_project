package ru.sbertroika.service_for_db.TMS.entities;

import java.util.UUID;

public class Terminal {
    private UUID id;
    private String serialNumber;
    private String title;
    private String type;
    private String organization;

    public Terminal(UUID id, String serialNumber, String title, String type, String organization) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.title = title;
        this.type = type;
        this.organization = organization;
    }
}
