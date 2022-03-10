package com.technomaker.demohibernate.service;

import com.technomaker.demohibernate.dao.FormationDao;
import com.technomaker.demohibernate.dao.ParticipantDao;
import com.technomaker.demohibernate.simple.Formation;
import com.technomaker.demohibernate.simple.Participant;

public class GestionnaireFormation {

    ParticipantDao participantDao = new ParticipantDao();
    FormationDao formationDao = new FormationDao();

    public Long saveFormation(Formation formation) {
        return formationDao.save(formation);
    }

    public Long saveParticipant(Participant participant) {
        return participantDao.save(participant);
    }

    public void addFormationToParticipant(Participant participant, Formation formation) {
        participant.setFormation(formation);
        participantDao.update(participant);
    }

}
