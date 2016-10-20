package edu.fjnu.Entity.Usual;


public class Action {
	private int id;
	private String action_name;
	private String image_url;
	private String content;
	private String action_type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAction_type() {
		return action_type;
	}
	public void setAction_type(String action_type) {
		this.action_type = action_type;
	}
	public Action(String action_name, String image_url, String content, String action_type) {
		super();
		this.action_name = action_name;
		this.image_url = image_url;
		this.content = content;
		this.action_type = action_type;
	}
	public Action() {
		super();
	}
}
