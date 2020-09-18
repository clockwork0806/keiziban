/**
 *
 */
package bean;


public class Keigiban_bean {

	private int id;
	private String name;
	private String mail;
	private String content;
	private String time;


	public Keigiban_bean(int id, String name, String content, String time) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.time = time;

	}
	public Keigiban_bean(String name, String mail, String content , String time ) {
		super();

		this.name = name;
		this.mail = mail;
		this.content = content;
		this.time = time;

	}
	public Keigiban_bean(String name, String mail, String content) {
		super();

		this.name = name;
		this.mail = mail;
		this.content = content;

	}
	public Keigiban_bean(int id,String name,String content) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;

	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
