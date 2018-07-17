package service;

import java.util.List;
import domain.*;

public interface ProjectTeamService {
	public void createProjectTeam(ProjectTeamBean bean);
	public List<ProjectTeamBean> listProjectTeam();
	public List<ProjectTeamBean> findProjectTeamByWord(String word);
	public ProjectTeamBean findProjectTeamBySeq(int seq);
	public int countProjectTeamBean();
	public void updateProjectTeam(ProjectTeamBean bean);
	public void deleteProjectTeam(ProjectTeamBean bean);
}
