package com.courses.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.classic.GroupByParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.components.entity.Student;
import com.courses.components.entity.Teacher;
import com.courses.components.entity.Team;
import com.courses.components.interfaces.ITeam;
import com.courses.components.persistence.HibernateUtil;

@Service
public class TeamService {
	@Autowired
	ITeam iTeam;

	public void createTeam(Team team) {
		iTeam.createTeam(team);
	}

	public List<Team> readAllTeam() {
		return iTeam.readAllTeam();
	}

	public void updateTeam(Integer id, Team team) {
		iTeam.updateTeam(id, team);
	}

	public void deleteTeam(Integer id) {
		iTeam.deleteTeam(id);
	}

	public Team getByIdTeam(Integer id) {
		return iTeam.getByIdTeam(id);
	}

	public Set<Student> getAllStudent(int id) {
		return iTeam.getAllStudent(id);
	}

	public Set<Teacher> getAllTeacher(int id) {
		return iTeam.getAllTeacher(id);
	}

	public List<Team> readAllTeamTeam() {
		DetachedCriteria query = DetachedCriteria.forClass(Team.class)
				.add(Restrictions.eq("name", "PR132"))
				.setProjection(Projections.projectionList()
                .add(Projections.groupProperty("name")));
		Session session = null;
		ArrayList<Team> result = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			result = (ArrayList<Team>) query.getExecutableCriteria(session).list();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return result;
	}
	
	public List<Team> readAllTeamTeamTeam() {
		DetachedCriteria query = DetachedCriteria.forClass(Team.class)
				.createAlias("id_Course", "cr")
				.add(Restrictions.eq("cr.id", 2))
				.setProjection(Projections.projectionList()
		        .add(Projections.groupProperty("name")));
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Team> result = (ArrayList<Team>) query.getExecutableCriteria(session).list();
		if (session.isOpen()) {
			session.close();
		}
		return result;
	}
}
