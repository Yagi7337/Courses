package com.courses.components.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.courses.components.entity.Student;
import com.courses.components.entity.Teacher;
import com.courses.components.entity.Team;
import com.courses.components.interfaces.ITeam;
import com.courses.components.persistence.HibernateUtil;

@Repository
public class TeamDao implements ITeam {
	@Override
	public void createTeam(Team team) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(
				new Team(team.getId(), team.getName(), team.getDate_start(), team.getDate_end(), team.getId_Course()));
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
	}

	 @Override
	 public List<Team> readAllTeam() {
	 Session session = HibernateUtil.getSessionFactory().openSession();
	 session.beginTransaction();
	 Query SQLQuery = session.createQuery("select t from Team t");
	 ArrayList<Team> result = (ArrayList<Team>)SQLQuery.list();
	 session.getTransaction().commit();
	 if (session.isOpen()) {
	 session.close();
	 }
	 return result;
	 }

	// @Override
	// public List<Team> readAllTeam() {
	// Session session = HibernateUtil.getSessionFactory().openSession();
	// session.beginTransaction();
	// List<Team> team = (List<Team>) session
	// .createSQLQuery("select id, name, date_start, date_end from Team order by
	// name").addScalar("id")
	// .addScalar("name").addScalar("date_start").addScalar("date_end")
	// .setResultTransformer(Transformers.aliasToBean(Team.class)).list();
	//
	// session.getTransaction().commit();
	// if (session.isOpen()) {
	// session.close();
	// }
	// return team;
	// }

//	 @Override
//	 public List<Team> readAllTeam() {
//	 Session session = HibernateUtil.getSessionFactory().openSession();
//	 session.beginTransaction();
//	 List<Team> team=(List<Team>)session.createCriteria(Team.class)
//			 .createAlias("id_Course", "iC")
//			 .add(Restrictions.eq("iC.id", 3)).list();
//	 session.getTransaction().commit();
//	 if (session.isOpen()) {
//	 session.close();
//	 }
//	 return team;
//	 }

//	 @Override
//	 public List<Team> readAllTeam() {
//	 Session session = HibernateUtil.getSessionFactory().openSession();
//	 session.beginTransaction();
//	 List<Team> team=(List<Team>)session.createCriteria(Team.class)
////			 .createAlias("studentForTeam", "tm")
////			 .add(Restrictions.eq("tm.name", "17"))
//			 .add(Restrictions.eq("name", "PR131")).list();
//	 session.getTransaction().commit();
//	 if (session.isOpen()) {
//	 session.close();
//	 }
//	 return team;
//	 }
	 
	@Override
	public void updateTeam(Integer id, Team group) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Team update = (Team) session.get(Team.class, id);
		update.setName(group.getName());
		update.setDate_start(group.getDate_start());
		update.setDate_end(group.getDate_end());
		update.setId_Course(group.getId_Course());
		session.update(update);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}

	}

	@Override
	public void deleteTeam(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Team del = (Team) session.get(Team.class, id);
		session.delete(del);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
	}

	@Override
	public Team getByIdTeam(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Team result = (Team) session.get(Team.class, id);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Set<Student> getAllStudent(int id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Team team = (Team) session.get(Team.class, id);
			session.getTransaction().commit();
			return team.getStudentForTeam();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Set<Teacher> getAllTeacher(int id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Team team = (Team) session.get(Team.class, id);
			session.getTransaction().commit();
			return team.getTeachers();
		} catch (Exception e) {
			throw e;
		}
	}
}
