package com.chainsys.LDM.Deduction;

import java.sql.SQLException;

public interface IdDetailsDAO {
	public void addMoneyInId(int a,int b) throws Exception ;
	public int updateAmtInId (int studentId, long ISBN) throws Exception; 
	public int updateAmtInWallet (int studentId, long ISBN) throws Exception; 
	public void libraryWallet() throws Exception ;
}
