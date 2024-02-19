package ru.sbertroika.service_for_db.TMS.entities;

import java.util.UUID;

public class Organization {
    private UUID id;
    private String name;
    private String inn;
    private String kpp;

    public Organization(UUID id, String name, String inn, String kpp) {
        this.id = id;
        this.name = name;
        this.inn = inn;
        this.kpp = kpp;
    }
}
