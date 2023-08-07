package model_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			DataSource ds = (DataSource)init.lookup("java:/comp/env/abc");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardDTO> list(PageData pd){
		sql = "select * from board order by gid desc, seq limit ?, ?";
		ArrayList<BoardDTO> res = new ArrayList<>();
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, pd.start);
			ptmt.setInt(2, pd.limit);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setId(rs.getInt("id"));
				dto.setGid(rs.getInt("gid"));
				dto.setCnt(rs.getInt("cnt"));
				dto.setLev(rs.getInt("lev"));
				dto.setSeq(rs.getInt("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPname(rs.getString("pname"));
				dto.setPw(rs.getString("pw"));
				dto.setUpfile(rs.getString("upfile"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				
				res.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();		
		}
		
		return res;
	}
	
	public int totalCnt() {
		
		sql = "select count(*) from board";
		int totalCnt = 0;
		
		try {
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			rs.next();
			totalCnt = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return totalCnt;
	}
	
	public BoardDTO detail(int id){
		sql = "select * from board where id = ?";		
		BoardDTO dto = null;
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, id);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDTO();
				dto.setId(rs.getInt("id"));
				dto.setGid(rs.getInt("gid"));
				dto.setCnt(rs.getInt("cnt"));
				dto.setLev(rs.getInt("lev"));
				dto.setSeq(rs.getInt("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPname(rs.getString("pname"));
				dto.setPw(rs.getString("pw"));
				dto.setUpfile(rs.getString("upfile"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();			
		}
		
		return dto;
	}
	
	public void addCount(int id){
		sql = "update board set cnt = cnt + 1 where id = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, id);
			ptmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();			
		}
	}
	
	public void write(BoardDTO dto){
		
		try {
			sql = "select max(id)+1 from board";
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			rs.next();
			dto.setId(rs.getInt(1));
			dto.setGid(rs.getInt(1));
			
			ptmt.close();
			
			sql = "insert into board(id, title, pname, content, pw, upfile, reg_date, cnt, seq, lev, gid) "
					+ "values(?, ?, ?, ?, ?, ?, sysdate(), -1, 0, 0, ?)";
			
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.getId());
			ptmt.setString(2, dto.getTitle());
			ptmt.setString(3, dto.getPname());
			ptmt.setString(4, dto.getContent());
			ptmt.setString(5, dto.getPw());
			ptmt.setString(6, dto.getUpfile());
			ptmt.setInt(7, dto.getId());
			ptmt.executeUpdate();
			
			ptmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();			
		}
	}
	
	public int delete(BoardDTO dto) {
		sql = "delete from board where id = ? and pw = ?";
		int res = 0;
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.getId());
			ptmt.setString(2, dto.getPw());
			res = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return res;
	}
	
	public BoardDTO idPwChk(BoardDTO dto) {
		sql = "select * from board where id = ? and pw = ?";
		BoardDTO res = null;
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.getId());
			ptmt.setString(2, dto.getPw());
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				res = new BoardDTO();
				res.setId(rs.getInt("id"));
				res.setUpfile(rs.getString("upfile"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return res;
	}
	
	public int modify(BoardDTO dto){
		sql = "update board set title = ?, pname = ?, content = ?, upfile = ? where id = ? and pw = ?";
		int res = 0;
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getTitle());
			ptmt.setString(2, dto.getPname());
			ptmt.setString(3, dto.getContent());
			ptmt.setString(4, dto.getUpfile());
			ptmt.setInt(5, dto.getId());
			ptmt.setString(6, dto.getPw());
			res = ptmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();			
		}
		return res;
	}
	
	public void fileDelete(BoardDTO dto) {
		sql = "update board set upfile = null where id = ? and pw = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.getId());
			ptmt.setString(2, dto.getPw());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void reply(BoardDTO dto){
		
		try {
			sql = "update board set seq = seq + 1 where gid = ? and seq > ?";
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.getGid());
			ptmt.setInt(2, dto.getSeq());
			ptmt.executeUpdate();
			ptmt.close();
			
			sql = "select max(id)+1 from board";
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			rs.next();
			dto.setId(rs.getInt(1));
			
			ptmt.close();
			
			sql = "insert into board(id, title, pname, content, pw, upfile, reg_date, cnt, seq, lev, gid) "
					+ "values(?, ?, ?, ?, ?, ?, sysdate(), -1, ?, ?, ?)";
			
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.getId());
			ptmt.setString(2, dto.getTitle());
			ptmt.setString(3, dto.getPname());
			ptmt.setString(4, dto.getContent());
			ptmt.setString(5, dto.getPw());
			ptmt.setString(6, dto.getUpfile());
			ptmt.setInt(7, dto.getSeq()+1);
			ptmt.setInt(8, dto.getLev()+1);
			ptmt.setInt(9, dto.getGid());
			ptmt.executeUpdate();
			
			ptmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();			
		}
	}
	
	public void close() {
		if(rs!=null) {try {rs.close();}catch(Exception e) {}}
		if(ptmt!=null) {try {ptmt.close();}catch(Exception e) {}}
		if(con!=null) {try {con.close();}catch(Exception e) {}}
	}
}
