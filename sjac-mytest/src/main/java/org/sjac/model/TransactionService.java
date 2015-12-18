package org.sjac.model;

import java.util.List;


public interface TransactionService {
	public abstract void TransactionAll(GroupVO gvo, GroupMemberVO gmvo) throws Exception;
	public abstract List<ScheduleVO> ScheduleTransaction(String id) throws Exception;
	public abstract void deleteGroupTransaction(String id);
	public abstract void deleteMemberTransaction(String id);
	public abstract void joinGroupTransaction(GroupJoinVO gjvo);
	public abstract void joinTransaction(String gLeaderId, String[] acceptList);
	public abstract void getAwayGroupMemberTransaction(String id, String gLeaderId);
	public abstract void leaveThisGroupTransaction(String id, String gLeaderId);
}
