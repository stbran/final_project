package ru.sbertroika.service_for_db.TMS.controllers;

import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;
import ru.sbertroika.service_for_db.TMS.JdbcService;
import ru.sbertroika.service_for_db.TMS.Queries;
import ru.sbertroika.service_for_db.TMS.entities.Terminal;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/terminal")
public class TerminalController {
    JdbcService service = new JdbcService();

    @GetMapping
    public String getTerminalList() {
        List<Terminal> terminals = service.getTerminalList();
        return new GsonBuilder().setPrettyPrinting().create().toJson(terminals);
    }

    @GetMapping("/name")
    public String getTerminalIdByName(@RequestParam String name) {
        String id = service.getIdByName(Queries.SELECT_ID_TERMINAL_BY_NAME, name);
        return new GsonBuilder().setPrettyPrinting().create().toJson(id);
    }

    @DeleteMapping("/id")
    public void deleteTerminalById(@RequestParam UUID id) {
        service.deleteTerminalById(id);
    }

    @DeleteMapping("/serial_number")
    public void deleteTerminalBySN(@RequestParam String serial_number) {
        service.deleteTerminalBySN(serial_number);
    }

    @GetMapping("/out")
    public void disconnect() {
        service.disconnect();
    }
}
