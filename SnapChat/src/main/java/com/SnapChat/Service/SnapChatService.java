package com.SnapChat.Service;

import java.util.List;

import com.SnapChat.Dao.SnapChatDao;
import com.SnapChat.Dao.SnapChatDaoInterface;
import com.SnapChat.Entity.SnapChatEntity;

public class SnapChatService implements SnapChatServiceInterface {
	SnapChatDaoInterface sdi = new SnapChatDao();
	
	@Override
	public int createAccount(SnapChatEntity se) {
		return sdi.createAccount(se);
	}

	@Override
	public SnapChatEntity viewAccount(SnapChatEntity se) {
		return sdi.viewAccount(se);
	}

	@Override
	public List<SnapChatEntity> viewAllAccount() {
		return sdi.viewAllAccount();
	}

	@Override
	public int editAccount(SnapChatEntity user) {
		return sdi.editAccount(user);
	}

	@Override
	public int deleteAccount(SnapChatEntity se) {
		return sdi.deleteAccount(se);
	}

	@Override
	public boolean loginAccount(SnapChatEntity se) {
		return sdi.loginAccount(se);
	}

	@Override
	public List<SnapChatEntity> searchAccount(String se) {
		return sdi.searchAccount(se);
	}

}
