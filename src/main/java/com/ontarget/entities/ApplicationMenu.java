package com.ontarget.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "application_menu")
public class ApplicationMenu implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "application_menu_id", nullable = false)
	private Integer applicationMenuId;
	@Column(name = "menu_name", length = 45)
	private String menuName;
	@Column(name = "menu_key", length = 45)
	private String menuKey;
	@Column(name = "active", length = 1)
	private Character active;

	public ApplicationMenu() {
	}

	public ApplicationMenu(Integer applicationMenuId) {
		this.applicationMenuId = applicationMenuId;
	}

	public Integer getApplicationMenuId() {
		return applicationMenuId;
	}

	public void setApplicationMenuId(Integer applicationMenuId) {
		this.applicationMenuId = applicationMenuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuKey() {
		return menuKey;
	}

	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}

	public Character getActive() {
		return active;
	}

	public void setActive(Character active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (applicationMenuId != null ? applicationMenuId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ApplicationMenu)) {
			return false;
		}
		ApplicationMenu other = (ApplicationMenu) object;
		if ((this.applicationMenuId == null && other.applicationMenuId != null)
				|| (this.applicationMenuId != null && !this.applicationMenuId.equals(applicationMenuId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ApplicationMenu[applicationMenuId=" + applicationMenuId + "]";
	}

}
