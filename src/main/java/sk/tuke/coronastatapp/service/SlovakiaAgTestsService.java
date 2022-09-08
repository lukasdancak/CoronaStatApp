package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.SlovakiaAgTests;

import java.util.List;

public interface SlovakiaAgTestsService {

    void addSlovakiaAgTests(SlovakiaAgTests slovakiaAgTests);

    List<SlovakiaAgTests> getAllSlovakiaAgTests();

    void deleteAllSlovakiaAgTests();
}
