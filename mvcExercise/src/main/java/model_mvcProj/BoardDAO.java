package model_mvcProj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public BoardDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:/comp/env/green_db322");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardDTO> list(){
		ArrayList<BoardDTO> list = new ArrayList<>();
		sql = "select * from board";
		
		try {
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO bA = new BoardDTO();
				
				bA.setId(rs.getInt("id"));
				bA.setCnt(rs.getInt("cnt"));
				bA.setLev(rs.getInt("lev"));
				bA.setSeq(rs.getInt("seq"));
				bA.setGid(rs.getInt("gid"));
				bA.setTitle(rs.getString("title"));
				bA.setContent(rs.getString("content"));
				bA.setWname(rs.getString("wname"));
				bA.setPw(rs.getString("pw"));
				bA.setUpfile(rs.getString("upfile"));
				bA.setReg_date(rs.getTimestamp("reg_date"));
				
				list.add(bA);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		
		return list;
	}
	
	public BoardDTO person(int id){
		BoardDTO bA = new BoardDTO();
		sql = "select * from board where id = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, id);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				
				bA.setId(rs.getInt("id"));
				bA.setCnt(rs.getInt("cnt"));
				bA.setLev(rs.getInt("lev"));
				bA.setSeq(rs.getInt("seq"));
				bA.setGid(rs.getInt("gid"));
				bA.setTitle(rs.getString("title"));
				bA.setContent(rs.getString("content"));
				bA.setWname(rs.getString("wname"));
				bA.setPw(rs.getString("pw"));
				bA.setUpfile(rs.getString("upfile"));
				bA.setReg_date(rs.getTimestamp("reg_date"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		
		return bA;
	}
	
	public void close() {
		if(con!=null) {try {con.close();}catch(Exception e) {}};
		if(ptmt!=null) {try {ptmt.close();}catch(Exception e) {}};
		if(rs!=null) {try {rs.close();}catch(Exception e) {}};
	}
}
