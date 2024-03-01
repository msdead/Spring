package ru.manerov.gb.actslog.service;

import org.springframework.stereotype.Service;
import ru.manerov.gb.actslog.model.Act;
import ru.manerov.gb.actslog.repositories.ActRepository;

import java.util.List;

@Service
public class ActService {
    private final ActRepository actRepository;

    public ActService(ActRepository actRepository) {
        this.actRepository = actRepository;
    }


    public List<Act> findAll(){
        return actRepository.findAll();
    }

    public Act saveAct(Act act){
        return actRepository.save(act);
    }

    public void deleteById(int id){
        actRepository.deleteById(id);
    }

    public Act getOneActByID(int id)  {
       return actRepository.getOne(id);
    }

    public Act updateAct(Act act){
        return actRepository.updateAct(act);
    }
}
