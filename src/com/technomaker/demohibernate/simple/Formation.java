package com.technomaker.demohibernate.simple;


import java.util.Set;

public class Formation {
	
	private Long id;
	private String theme;
	private Set<Participant> participants;

	public Formation() {
	}

	public Formation(String theme) {
		this.theme = theme;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

}
