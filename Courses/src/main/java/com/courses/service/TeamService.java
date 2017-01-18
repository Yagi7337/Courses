package com.courses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.components.entity.Team;
import com.courses.components.interfaces.ITeam;

@Service
public class TeamService {
	@Autowired
	ITeam iTeam;
	
	public void createTeam(Team team){
		iTeam.createTeam(team);
	}
	
	public List<Team> readAllTeam() {		
		return iTeam.readAllTeam();
	}

	public void updateTeam(Integer id, Team team){
		iTeam.updateTeam(id, team);
	}

	public void deleteTeam(Integer id){
		iTeam.deleteTeam(id);
	}
	
	public Team getByIdTeam(Integer id){
		return iTeam.getByIdTeam(id);
	}
}
