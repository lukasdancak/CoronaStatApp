package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.coronastatapp.entity.SlovakiaAgTests;
import sk.tuke.coronastatapp.service.SlovakiaAgTestsService;

import java.util.List;

@RestController
@RequestMapping("/api/ag-tests/in-slovakia")
public class SlovakiaAgTestsWebServiceRest {

    @Autowired
    private SlovakiaAgTestsService slovakiaAgTestsService;

//    @PostMapping("/new")
//    public void addSlovakiaAgTests(@RequestBody SlovakiaAgTests slovakiaAgTests) {
//        slovakiaAgTestsService.addSlovakiaAgTests(slovakiaAgTests);
//    }

    @GetMapping
    public List<SlovakiaAgTests> getAllSlovakiaAgTests() {
        return slovakiaAgTestsService.getAllSlovakiaAgTests();
    }
}
