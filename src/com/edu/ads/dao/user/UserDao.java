package com.edu.ads.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.edu.ads.bean.user.User;
import com.edu.ads.dao.imp.DaoSupport;

@Repository
public class UserDao extends DaoSupport<User> {

	/**
	 * 用户名是否存在
	 * 
	 * @param userName
	 * @return
	 */
	public boolean userNameExist(String userName) {
		String sql = "select count(c_username) from t_ry where c_username=?";
		int count = getJdbcTemplate().queryForInt(sql, userName);
		if (count > 0) {
			return true;
		}
		return false;
	}

	public User getUser(String userName, String password) {
		StringBuffer sql = new StringBuffer();
		sql.append(" from User where ");
		sql.append(" userName =? ");
		sql.append(" and password = ?");
		List<User> users = findList(sql.toString(), new Object[] { userName,
				password });
		if (!CollectionUtils.isEmpty(users)) {
			return users.get(0);
		}
		return null;
	}

	/**
	 * 根据
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean userExsist(String userName, String password) {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(id) from t_user where ");
		sql.append(" c_username =? ");
		sql.append(" and c_password = ?");
		int count = getJdbcTemplate().queryForInt(sql.toString(),
				new Object[] { userName, password });
		if (count > 0) {
			return true;
		}
		return false;

	}

}
