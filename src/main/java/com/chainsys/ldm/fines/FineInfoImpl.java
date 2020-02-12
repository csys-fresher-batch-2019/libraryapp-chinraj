package com.chainsys.ldm.fines;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chainsys.ldm.bookSummary.TestConnection;

import logger.Logger;

public class FineInfoImpl implements FineInfoDAO {
	Logger logger = Logger.getInstance();

	public void AddFineInfo(FinesInfo FI) {

		String sqlinsert = "insert into fine_amount(student_id,ISBN,fines_per_day) values(?,?,?)";
		logger.info(sqlinsert);
		try (Connection con = TestConnection.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
				stmt.setInt(1, FI.getStudentId());
				stmt.setLong(2, FI.getISBN());
				stmt.setInt(3, FI.getFinePerDay());
				int rows = stmt.executeUpdate();
				logger.info("" + rows);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public void AddFineInfo1(FinesInfo FO) {
		try (Connection con = TestConnection.getConnection();) {
			String sql1 = " update fine_amount set no_of_extra_days = trunc(sysdate - (select due_date from book_summary where ISBN=? ))";
			try (PreparedStatement stmt4 = con.prepareStatement(sql1);) {
				stmt4.setLong(1, FO.getISBN());
				int row1 = stmt4.executeUpdate();
				logger.info(row1);
				logger.info(sql1);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public int TotalFinesAmt(FinesInfo FT) {
		try (Connection con = TestConnection.getConnection();) {
			String sql0 = "update fine_amount set fines=0, no_of_extra_days=0 where trunc(( sysdate-(select due_date from book_summary where ISBN=?)))<=0 ";
			try (PreparedStatement stm = con.prepareStatement(sql0);) {
				stm.setLong(1, FT.getISBN());
				int row = stm.executeUpdate();
				logger.info(row);
				logger.info(sql0);

				String sql5 = "  update fine_amount set fines= no_of_extra_days * fines_per_day where student_id= ? and ISBN=?";
				try (PreparedStatement s = con.prepareStatement(sql5);) {
					s.setInt(1, FT.getStudentId());
					s.setLong(2, FT.getISBN());
					int rowq = s.executeUpdate();
					logger.info(rowq);
					logger.info(sql5);
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return 0;
	}

	public int FinePerStudent(int studentId, long ISBN) {
		FinesInfo b = new FinesInfo();
		String sql6 = "select fines from fine_amount where student_id = ? and ISBN = ?";
		try (Connection con = TestConnection.getConnection();) {
			try (PreparedStatement pst = con.prepareStatement(sql6);) {
				pst.setInt(1, studentId);
				pst.setLong(2, ISBN);
				logger.info(sql6);
				try (ResultSet rs = pst.executeQuery();) {
					rs.next(); 
						b.setFines(rs.getInt(1));
						if (b.getFines() == 0) {
							String sql = "update fine_amount set fine_status ='paid' where student_id=? and ISBN = ?";
							try (Connection con1 = TestConnection.getConnection();) {
								try (PreparedStatement pst1 = con1.prepareStatement(sql6);) {
									pst1.setInt(1, studentId);
									pst1.setLong(2, ISBN);
									int row = pst1.executeUpdate();	
									logger.info(sql);
									logger.info(row);
								}
							}}
						else {
							
									
									
					logger.info(b.getFines());
									}
				}	}
		} catch (Exception e) {
			logger.error(e);
		}
		return b.getFines();
	}
		
	public int bookreturned(int studentId, long iSBN) {
		try (Connection con = TestConnection.getConnection();) {
			String sql3 = "update book_summary set status ='Returned',return_date=sysdate where student_id =? and ISBN = ?";
			try (PreparedStatement stmt = con.prepareStatement(sql3);) {
				stmt.setInt(1, studentId);
				stmt.setLong(2, iSBN);
				int row3 = stmt.executeUpdate();
				logger.info(row3);
				logger.info(sql3);
				String sql0 = "update booklist set book_status = 'Available' where ISBN = ?";
				try (PreparedStatement stmt5 = con.prepareStatement(sql0);) {
					stmt5.setLong(1, iSBN);
					int row4 = stmt5.executeUpdate();
					logger.info(row4);
					logger.info(sql0);
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return 0;
	}

	public int PenalityForBookLost(int studentId, long ISBN) {
		try (Connection con = TestConnection.getConnection();) {
			String sql3 = "update fine_amount set lost_penality = (select price from booklist where ISBN =?) where ISBN =?";
			try (PreparedStatement stmt = con.prepareStatement(sql3);) {
				stmt.setLong(1, ISBN);
				stmt.setLong(2, ISBN);
				int row3 = stmt.executeUpdate();
				logger.info(row3);
				logger.info(sql3);
				String sql = "Select lost_penality from fine_amount where ISBN=?";
				try (PreparedStatement stmt1 = con.prepareStatement(sql);) {
					stmt1.setLong(1, ISBN);
					try (ResultSet row = stmt1.executeQuery();) {
						while (row.next()) {
							int status = row.getInt("lost_penality");
							System.out.println(status);
							logger.info(row);
							logger.info(sql);
						}
						return row3;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return 0;
	}

	public int renewal(int studentId, Long isbn) {
		int row = 0;
		try (Connection con = TestConnection.getConnection();) {
			String sqll = "select fine_status from fine_amount where student_id=? and ISBN =?";
			try (PreparedStatement pst = con.prepareStatement(sqll);) {
				pst.setInt(1, studentId);
				pst.setLong(2, isbn);
				
				try (ResultSet row3 = pst.executeQuery();) {
					
					while (row3.next()) {
						System.out.println(1);
						String status = row3.getString("fine_status");
						System.out.println(status);
						if (status.contentEquals("paid")) {
							Connection con1 = TestConnection.getConnection();
							String sql3 = "update book_summary set renewal_count =  renewal_count-1, due_date=due_date+10"
									+ " where student_id=? and ISBN = ?";
							try (PreparedStatement stmt = con1.prepareStatement(sql3);) {
								stmt.setInt(1, studentId);
								stmt.setLong(2, isbn);
								row = stmt.executeUpdate();
								System.out.println(sql3);
								System.out.println(row);
							}}
						else 
						{
							logger.info("Pay Fine amount");
						}}
								if(row==1) {
									logger.info("renewal sucess");}
									else
									{
										logger.info("not Sucess");
									
								}
							
						
			
			}}
		}catch (Exception e) {
			logger.error(e);	
		}
		return row;
			}}
