package com.chainsys.LDM.Deduction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

import com.chainsys.LDM.BookSummary.TestConnection;
import com.chainsys.LDM.Deduction.IdDetails;

import Logger.Logger;

public class IdDetailsImp implements IdDetailsDAO {
	Logger logger = Logger.getInstance();
	IdDetails bb = new IdDetails();

	public void addMoneyInId(int a, int b) throws Exception {
		String sqlinsert = "insert into amount(student_id,amount_in_id) values(?,?)";
		logger.info(sqlinsert);
		try (Connection con = TestConnection.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
				stmt.setInt(1, a);
				stmt.setInt(2, b);

				int rows = stmt.executeUpdate();
				logger.info("" + rows);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public int updateAmtInId(int studentId, long iSBN) throws Exception {
		try (Connection con = TestConnection.getConnection();) {
			String sql5 = "update amount set amount_in_id = amount_in_id-(select fines from fine_amount where student_id=? and ISBN=?)where student_id=?";
			try (PreparedStatement s = con.prepareStatement(sql5);) {
				s.setInt(1, studentId);
				s.setLong(2, iSBN);
				s.setInt(3, studentId);
				int rowq = s.executeUpdate();
				logger.info(sql5);
				logger.info(rowq);

			}
		} catch (Exception e) {
			logger.error(e);
		}
		return 0;
	}

	public int updateAmtInWallet(int studentId, long ISBN) throws Exception {
		try (Connection con = TestConnection.getConnection();) {
			String sql7 = "update amount set library_wallet = library_wallet + (select fines from fine_amount where student_id=? and ISBN=?) where student_id=?";
			try (PreparedStatement s = con.prepareStatement(sql7);) {
				s.setInt(1, studentId);
				s.setLong(2, ISBN);
				s.setInt(3, studentId);
				int rowq = s.executeUpdate();
				logger.info(rowq);

				String sql8 = " update fine_amount set fine_status= 'paid' where student_id= ? and ISBN =?";

				try (PreparedStatement t = con.prepareStatement(sql8);) {
					s.setInt(1, studentId);
					s.setLong(2, ISBN);

					int row1 = t.executeUpdate();
					logger.info(row1);
					logger.info(sql7);

					return rowq;
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return 0;
	}

	public void libraryWallet() throws Exception {
		try (Connection con = TestConnection.getConnection();) {
			try (CallableStatement Stmt = con.prepareCall("{call LIB_WALLET_PROC(?)}");) {
				Stmt.registerOutParameter(1, Types.INTEGER);
				Stmt.executeUpdate();
				int libraryWallet = Stmt.getInt(1);
				logger.info(libraryWallet);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
}
