package com.chainsys.ldm.deduction;

public interface IdDetailsDAO {
	public void addMoneyInId(int a,int b);
	public int updateAmtInId (int studentId, long ISBN); 
	public int updateAmtInWallet (int studentId, long ISBN); 
	public void libraryWallet();
}
