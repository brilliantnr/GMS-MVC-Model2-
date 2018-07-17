package service;

import java.util.*;

import dao.*;
import domain.*;

public class ProjectTeamServiceImpl implements ProjectTeamService{

	private static ProjectTeamService instance = new ProjectTeamServiceImpl();
	public static ProjectTeamService getInstance() {return instance;}
	private ProjectTeamServiceImpl() {
	}
	@Override
	public void createProjectTeam(ProjectTeamBean bean) {
		ProjectTeamDaoImpl.getInstance().insertProjectTeam(bean);
	}
	@Override
	public List<ProjectTeamBean> listProjectTeam() {
		List<ProjectTeamBean> lst=null;
		ProjectTeamDaoImpl.getInstance().listProjectTeam();
		return lst;
	}
	@Override
	public List<ProjectTeamBean> findProjectTeamByWord(String word) {
		List<ProjectTeamBean> lst=null;
		ProjectTeamDaoImpl.getInstance().selectProjectTeamByWord(word);
		return lst;
	}
	@Override
	public ProjectTeamBean findProjectTeamBySeq(int seq) {
		ProjectTeamBean bean = null;
		ProjectTeamDaoImpl.getInstance().selectProjectTeamBySeq(seq);
		return bean;
	}
	@Override
	public int countProjectTeamBean() {
		int teamseq =999;
		ProjectTeamDaoImpl.getInstance().countProjectTeam();
		return teamseq;
	}
	@Override
	public void updateProjectTeam(ProjectTeamBean bean) {
		ProjectTeamDaoImpl.getInstance().updateProjectTeam(bean);
	}
	@Override
	public void deleteProjectTeam(ProjectTeamBean bean) {
		ProjectTeamDaoImpl.getInstance().deleteProjectTeam(bean);
	}
	
	

}
