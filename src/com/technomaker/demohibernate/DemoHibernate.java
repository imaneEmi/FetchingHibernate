package com.technomaker.demohibernate;

import com.technomaker.demohibernate.service.GestionnaireFormation;
import com.technomaker.demohibernate.simple.Formation;
import com.technomaker.demohibernate.simple.Participant;


import java.util.Set;

public class DemoHibernate {

    public static void main(String[] args) {
        GestionnaireFormation gestionnaireFormation = new GestionnaireFormation();

        Formation formationHibernate = new Formation("Hibernate");
        Formation formationJpa = new Formation("JPA");
        Formation formationDocker = new Formation("Docker");

        Participant participant = new Participant("EL AIMANI", "Imane", formationHibernate);
        Participant participant2 = new Participant("IMAAZI", "Asmae");
        Participant participantToDelete = new Participant("Suicidal", "Person");
        gestionnaireFormation.saveParticipant(participant2);
        gestionnaireFormation.saveParticipant(participantToDelete);

        formationHibernate.setParticipants(Set.of(participant,participant2));
        Long formationHibernateId = gestionnaireFormation.saveFormation(formationHibernate);
        Long formationJpaId = gestionnaireFormation.saveFormation(formationJpa);
        Long formationDockerId = gestionnaireFormation.saveFormation(formationDocker);

        //find formation by theme
        System.out.println("-----------FindFormationByTheme :");
        System.out.println(gestionnaireFormation.findFormationByTheme("JPA"));

        participant2.setFormation(formationHibernate);
        gestionnaireFormation.updateParticipant(participant2);

        //retrieving data
        Formation formation1 = gestionnaireFormation.findFormationById(formationHibernateId);
        System.out.println("-----------Formation : "+formation1.getTheme());
        System.out.println("-----------Les participants de cet formation : "+formation1.getParticipants());

        //getAll
        System.out.println("-----------All Formations");
        System.out.println(gestionnaireFormation.findAllFormations());
        System.out.println("-----------All Participants");
        System.out.println(gestionnaireFormation.findAllParticipants());

        //update
        System.out.println("-----------Updating Formation...");
        formationJpa.setParticipants(Set.of(new Participant("ZACHRAB","Zineb",formationJpa)));
        gestionnaireFormation.updateFormation(formationJpa);

        System.out.println("-----------Updating Participant...");
        participant.setNom("EL");
        participant.setFormation(formationDocker);
        gestionnaireFormation.updateParticipant(participant);

        //delete
        System.out.println("-----------Deleting Formation...");
        gestionnaireFormation.deleteFormation(formationHibernate);

        System.out.println("-----------All Formations");
        System.out.println(gestionnaireFormation.findAllFormations());

        System.out.println("-----------Deleting Participant...");
        gestionnaireFormation.deleteParticipant(participantToDelete);
        System.out.println("-----------All Participants");
        System.out.println(gestionnaireFormation.findAllParticipants());


    }
}
