package com.technomaker.demohibernate;

import com.technomaker.demohibernate.service.GestionnaireFormation;
import com.technomaker.demohibernate.simple.Formation;
import com.technomaker.demohibernate.simple.Participant;

import java.util.HashSet;
import java.util.Set;

public class DemoHibernate {

	public static void main(String[] args) {
		GestionnaireFormation gestionnaireFormation = new GestionnaireFormation();
		
		Formation formation = new Formation("Hibernate");
		gestionnaireFormation.saveFormation(formation);

		Participant participant  =  new Participant("EL AIMANI","Imane",formation);
		gestionnaireFormation.saveParticipant(participant);
		gestionnaireFormation.addFormationToParticipant(participant,new Formation("JPA"));

		Set<Participant> participants = new HashSet<>();
		participants.add(new Participant("Imazzi","Asmae",formation));
		formation.setParticipants(participants);
		gestionnaireFormation.saveFormation(formation);

	}
}
