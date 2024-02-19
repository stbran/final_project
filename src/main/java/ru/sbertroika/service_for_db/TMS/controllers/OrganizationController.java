package ru.sbertroika.service_for_db.TMS.controllers;

import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;
import ru.sbertroika.service_for_db.TMS.JdbcService;
import ru.sbertroika.service_for_db.TMS.Queries;
import ru.sbertroika.service_for_db.TMS.entities.Organization;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
    JdbcService service = new JdbcService();

    @GetMapping
    public String getOrganizationList() {
        List<Organization> orgs = service.getOrganizationList();
        return new GsonBuilder().setPrettyPrinting().create().toJson(orgs);
    }

    @GetMapping("/name")
    public String getOrganizationIdByName(@RequestParam String name) {
        String id = service.getIdByName(Queries.SELECT_ID_ORGANIZATION_BY_NAME, name);
        return new GsonBuilder().setPrettyPrinting().create().toJson(id);
    }

    @DeleteMapping("/id")
    public void deleteOrganizationById(@RequestParam UUID id) {
        service.deleteOrganizationById(id);
    }

}
