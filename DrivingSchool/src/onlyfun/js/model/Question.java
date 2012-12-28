package onlyfun.js.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
	private Long id;
	private String title;
	private int answer;
	private Set<QuestionItem> items = new HashSet<QuestionItem>();

	@Id
	@GeneratedValue
	@Column(name = "questionId")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@OneToMany(mappedBy = "question", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	public Set<QuestionItem> getItems() {
		return items;
	}

	public void setItems(Set<QuestionItem> items) {
		this.items = items;
	}

	/**
	 * @return the answer
	 */
	public int getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(int answer) {
		this.answer = answer;
	}

}
