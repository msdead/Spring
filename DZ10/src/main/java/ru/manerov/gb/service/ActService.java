package ru.manerov.gb.service;


import ru.manerov.gb.model.Act;

import java.util.List;


public interface ActService {
    List<Act> getAllActs();
    Act createAct(Act note);
    Act getActById(Long id);
    Act updateAct(Act act);
    void deleteAct(Long id);
    List<Act> findActByReportingPeriod(String reportingPeriod);
}
