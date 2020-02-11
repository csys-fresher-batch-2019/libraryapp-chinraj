package com.chainsys.LDM.Fines;

import com.chainsys.LDM.Fines.FinesInfo;

public interface FineInfoDAO {
	public void AddFineInfo(FinesInfo FI) throws Exception;
	public void AddFineInfo1 (FinesInfo FO) throws Exception;
	public int TotalFinesAmt(FinesInfo f) throws Exception ;
	public int FinePerStudent(int studentId, long ISBN) throws Exception;
	public int bookreturned(int studentId,long ISBN) throws Exception;
	public void renewal(int studentId, Long isbn) throws Exception;
public int PenalityForBookLost(int studentId, long ISBN) throws Exception;
}