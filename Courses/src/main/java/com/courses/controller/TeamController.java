package com.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.courses.components.entity.Team;
import com.courses.service.TeamService;

@RestController
@RequestMapping(value = "/team")
public class TeamController {
	@Autowired
	TeamService teamService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createCourse(@RequestBody Team team) {
		teamService.createTeam(team);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Team> readAllTeam() {
		return teamService.readAllTeam();
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updateTeam(@PathVariable("id") Integer id, @RequestBody Team team) {
		teamService.updateTeam(id, team);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteTeam(@PathVariable("id") Integer id) {
		teamService.deleteTeam(id);
	}

	@RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
	public Team getByIdTeam(@PathVariable("id") Integer id) {
		return teamService.getByIdTeam(id);
	}

}
