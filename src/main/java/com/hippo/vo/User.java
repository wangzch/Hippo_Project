package com.hippo.vo;
/**
 * 用户表
 * @author Administrator
 *
 */
public class User {
    private Integer id;

    private String username;

    private String dspname;

    private String password;
    
    private String telphone;
    
    private String email;
    
    private String salt;//shiro密码
    
    private Integer status;
    
    private String create_date;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDspname() {
        return dspname;
    }

    public void setDspname(String dspname) {
        this.dspname = dspname == null ? null : dspname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	
}