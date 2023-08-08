package model_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GalleryDAO {
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public GalleryDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:/comp/env/abc");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<GalleryDTO> list(){
		ArrayList<GalleryDTO> arrDto = new ArrayList<>();
		sql = "select * from gallery";
		
		try {
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				GalleryDTO gDto = new GalleryDTO();
				gDto.setId(rs.getInt("id"));
				gDto.setTitle(rs.getString("title"));
				gDto.setPname(rs.getString("pname"));
				gDto.setPw(rs.getString("pw"));
				gDto.setUpfile(rs.getString("upfile"));
				gDto.setDescriptions(rs.getString("descriptions"));
				gDto.setReg_date(rs.getTimestamp("reg_date"));
				gDto.setCnt(rs.getInt("cnt"));
				
				arrDto.add(gDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return arrDto;
	}
	
	public void write(GalleryDTO gDto) {
		sql = "insert into gallery(title, pname, pw, upfile, descriptions, reg_date, cnt) "
				+ "values(?, ?, ?, ?, ?, sysdate(), 0)";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, gDto.getTitle());
			ptmt.setString(2, gDto.getPname());
			ptmt.setString(3, gDto.getPw());
			ptmt.setString(4, gDto.getUpfile());
			ptmt.setString(5, gDto.getDescriptions());
			ptmt.executeUpdate();
			
			ptmt.close();
			
			sql = "select max(id) from gallery";
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			rs.next();
			gDto.setId(rs.getInt(1));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public GalleryDTO detail(GalleryDTO gDto) {
		GalleryDTO dgDto = null;
		
		try {
			sql = "update gallery set cnt = cnt + 1 where id = ?";
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, gDto.getId());
			ptmt.executeUpdate();
			ptmt.close();
			
			sql = "select * from gallery where id = ?";
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, gDto.getId());
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				dgDto = new GalleryDTO();
				dgDto.setId(rs.getInt("id"));
				dgDto.setTitle(rs.getString("title"));
				dgDto.setPname(rs.getString("pname"));
				dgDto.setDescriptions(rs.getString("descriptions"));
				dgDto.setUpfile(rs.getString("upfile"));
				dgDto.setReg_date(rs.getTimestamp("reg_date"));
				dgDto.setCnt(rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return dgDto;
	}
	
	public GalleryDTO isIdPwChk(GalleryDTO gDto) {
		sql = "select * from gallery where id = ? and pw = ?";
		
		GalleryDTO ggDto = new GalleryDTO();
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, gDto.getId());
			ptmt.setString(2, gDto.getPw());
			rs = ptmt.executeQuery();
			
			rs.next();
			ggDto.setUpfile(rs.getString("upfile"));
			ggDto.setId(rs.getInt("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return ggDto;
	}
	
	public void delete(GalleryDTO gDto) {
		sql = "delete from gallery where id = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, gDto.getId());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}	
	}
	
	public void update(GalleryDTO gDto) {
		sql = "update gallery set title = ?, descriptions = ?, upfile = ? where id = ? and pw = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, gDto.getTitle());
			ptmt.setString(2, gDto.getDescriptions());
			ptmt.setString(3, gDto.getUpfile());
			ptmt.setInt(4, gDto.getId());
			ptmt.setString(5, gDto.getPw());
			ptmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void fildUpdate(GalleryDTO gDto) {
		sql = "update gallery set upfile = '' where id = ? and pw = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, gDto.getId());
			ptmt.setString(2, gDto.getPw());
			ptmt.executeUpdate();
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
