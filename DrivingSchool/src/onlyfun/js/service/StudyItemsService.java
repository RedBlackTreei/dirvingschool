package onlyfun.js.service;

import java.util.List;

import onlyfun.js.model.StudyItems;

public interface StudyItemsService {
	
	public List<StudyItems> getStudyItems();

	public StudyItems getStudyItems(long id);

	public void addStudyItems(StudyItems item);

	public void deleteStudyItems(long id);

	public void update(StudyItems items);

	public void update(long id);
}
