package dao;

import java.util.*;
import domain.*;

public interface ProjectTeamDao {
	public void insertProjectTeam(ProjectTeamBean bean);
	public List<ProjectTeamBean> listProjectTeam();
	public List<ProjectTeamBean> selectProjectTeamByWord(String word);
	public ProjectTeamBean selectProjectTeamBySeq(int seq);
	public int countProjectTeam();
	public void updateProjectTeam(ProjectTeamBean bean);
	public void deleteProjectTeam(ProjectTeamBean bean);
}
