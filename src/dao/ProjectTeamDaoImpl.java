package dao;

import java.util.List;

import domain.ProjectTeamBean;

public class ProjectTeamDaoImpl implements ProjectTeamDao{

	private static ProjectTeamDao instance = new ProjectTeamDaoImpl();
	public static ProjectTeamDao getInstance() {return instance;}
	private ProjectTeamDaoImpl() {}
	@Override
	public void insertProjectTeam(ProjectTeamBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ProjectTeamBean> listProjectTeam() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProjectTeamBean> selectProjectTeamByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProjectTeamBean selectProjectTeamBySeq(int seq) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countProjectTeam() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateProjectTeam(ProjectTeamBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteProjectTeam(ProjectTeamBean bean) {
		// TODO Auto-generated method stub
		
	}

	

}
