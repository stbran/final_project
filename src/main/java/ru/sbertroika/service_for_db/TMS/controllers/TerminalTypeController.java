package ru.sbertroika.service_for_db.TMS.controllers;

import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;
import ru.sbertroika.service_for_db.TMS.JdbcService;
import ru.sbertroika.service_for_db.TMS.Queries;
import ru.sbertroika.service_for_db.TMS.entities.TerminalType;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/type")
public class TerminalTypeController {
    JdbcService service = new JdbcService();

    @GetMapping
    public String getTypeList() {
        List<TerminalType> types = service.getTypeList();
        return new GsonBuilder().setPrettyPrinting().create().toJson(types);
    }

    @GetMapping("/name")
    public String getTypeIdByName(@RequestParam String name) {
        String id = service.getIdByName(Queries.SELECT_ID_TYPE_BY_NAME, name);
        return new GsonBuilder().setPrettyPrinting().create().toJson(id);
    }

    @DeleteMapping("/id")
    public void deleteTYPEById(@RequestParam UUID id) {
        service.deleteTYPEById(id);
    }
}
