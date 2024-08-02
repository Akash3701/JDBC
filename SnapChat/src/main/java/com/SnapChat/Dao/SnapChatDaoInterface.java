package com.SnapChat.Dao;

import java.util.List;

import com.SnapChat.Entity.SnapChatEntity;

public interface SnapChatDaoInterface {

	int createAccount(SnapChatEntity se);

	SnapChatEntity viewAccount(SnapChatEntity se);

	List<SnapChatEntity> viewAllAccount();

	int editAccount(SnapChatEntity user);

	int deleteAccount(SnapChatEntity se);
}
