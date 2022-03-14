package com.technomaker.demohibernate.service;

import com.technomaker.demohibernate.dao.FormationDao;
import com.technomaker.demohibernate.dao.ParticipantDao;
import com.technomaker.demohibernate.simple.Formation;
import com.technomaker.demohibernate.simple.Participant;

import java.util.List;

public class GestionnaireFormation {

    ParticipantDao participantDao = new ParticipantDao();
    FormationDao formationDao = new FormationDao();

    public Long saveFormation(Formation formation) {
        return formationDao.save(formation);
    }

    public Formation findFormationById(Long id){
        return formationDao.findById(id);
    }

    public Formation findFormationByTheme(String theme) {
        return formationDao.findByTheme(theme);
    }

    public List<Formation> findAllFormations(){
        return formationDao.findAll();
    }

    public void updateFormation(Formation formation){
        formationDao.update(formation);
    }

    public void deleteFormation(Formation formation){
        if(formation.getParticipants().isEmpty()){
            formationDao.delete(formation.getId());
        }
        else {
            formation.getParticipants().forEach(participant -> participantDao.delete(participant));
            formationDao.delete(formation.getId());
        }
    }

    ////////////////////////////////////////////////

    public Long saveParticipant(Participant participant) {
        return participantDao.save(participant);
    }

    public Participant findParticipantById(Long id){
        return participantDao.findById(id);
    }

    public List<Participant> findAllParticipants(){
        return participantDao.findAll();
    }

    public void updateParticipant(Participant participant) {
        participantDao.update(participant);
    }

    public void deleteParticipant(Participant participant){
        participantDao.delete(participant);
    }

}
