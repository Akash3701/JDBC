package com.SnapChat.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.SnapChat.Entity.SnapChatEntity;

public class SnapChatDao implements SnapChatDaoInterface {

	@Override
	public int createAccount(SnapChatEntity se) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/snapchat", "root", "MySql@123@");
			PreparedStatement ps = con
					.prepareStatement("insert into user(username, email, phoneno, password) values(?, ?, ?, ?)");

			ps.setString(1, se.getUsername());
			ps.setString(2, se.getEmail());
			ps.setInt(3, se.getPhoneno());
			ps.setString(4, se.getPassword());
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public SnapChatEntity viewAccount(SnapChatEntity se) {
		SnapChatEntity entity = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/snapchat", "root", "MySql@123@");
			PreparedStatement ps = con.prepareStatement("select * from user where email=?");

			ps.setString(1, se.getEmail());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				entity = new SnapChatEntity();
				entity.setUsername(rs.getString("username"));
				entity.setEmail(rs.getString("email"));
				entity.setPhoneno(rs.getInt("phoneno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public List<SnapChatEntity> viewAllAccount() {
		List<SnapChatEntity> users = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/snapchat", "root", "MySql@123@");
			PreparedStatement ps = con.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				SnapChatEntity se = new SnapChatEntity();
				se.setUsername(rs.getString("username"));
				se.setEmail(rs.getString("email"));
				se.setPhoneno(rs.getInt("phoneno"));
				users.add(se);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public int editAccount(SnapChatEntity user) {
	    int result = 0;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/snapchat", "root", "MySql@123@");
	        PreparedStatement ps = con.prepareStatement("UPDATE user SET username=?, phoneno=?, password=? WHERE email=?");

	        ps.setString(1, user.getUsername());
	        ps.setInt(2, user.getPhoneno());
	        ps.setString(3, user.getPassword());
	        ps.setString(4, user.getEmail());

	        result = ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}


	@Override
	public int deleteAccount(SnapChatEntity se) {
		int result = 0;
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/snapchat", "root", "MySql@123@");
            PreparedStatement ps = con.prepareStatement("delete from user where email=?");

            ps.setString(1, se.getEmail());
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
	}
}
