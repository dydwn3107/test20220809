package com.yedam.carmember;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class CarmemberDAO extends DAO {

	private static CarmemberDAO cd = new CarmemberDAO();

	private CarmemberDAO() {

	}

	public static CarmemberDAO getInstance() {
		return cd;
	}

	public Carmember loginInfo(String id) {
		Carmember carmember = null;
		try {
			conn();
			String sql = "select * from carmember where carmember_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				carmember = new Carmember();
				carmember.setCarmemberId(rs.getString("carmember_id"));
				carmember.setCarmemberPw(rs.getString("carmember_pw"));
				carmember.setCarmemberName(rs.getString("carmember_name"));
				carmember.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return carmember;
	}

	public int registMember(Carmember carmember) {
		int result = 0;
		try {
			conn();
			String sql = "insert into carmember " + "(carmember_id, carmember_pw, carmember_name, "
					+ "carmember_carnum, carmember_carname, carmember_email, "
					+ "carmember_address, role) values (?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carmember.getCarmemberId());
			pstmt.setString(2, carmember.getCarmemberPw());
			pstmt.setString(3, carmember.getCarmemberName());
			pstmt.setString(4, carmember.getCarmemberCarnum());
			pstmt.setString(5, carmember.getCarmemberCarname());
			pstmt.setString(6, carmember.getCarmemberEmail());
			pstmt.setString(7, carmember.getCarmemberAddress());
			pstmt.setString(8, carmember.getRole());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	public List<Carmember> getDetailCarmember() {
		List<Carmember> list = new ArrayList<>();
		Carmember carmember = null;
		try {
			conn();
			String sql = "select * from carmember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				carmember = new Carmember();
				carmember.setCarmemberId(rs.getString("carmember_id"));
				carmember.setCarmemberPw(rs.getString("carmember_pw"));
				carmember.setCarmemberName(rs.getString("carmember_name"));
				carmember.setCarmemberCarnum(rs.getString("carmember_carnum"));
				carmember.setCarmemberCarname(rs.getString("carmember_carname"));
				carmember.setCarmemberEmail(rs.getString("carmember_email"));
				carmember.setCarmemberAddress(rs.getString("carmember_address"));
				list.add(carmember);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public List<Carmember> getCarmember(String carmemberId) {
		List<Carmember> list = new ArrayList<>();
		Carmember carmember = null;
		try {
			conn();
			String sql = "select * from carmember where carmember_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carmemberId);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				carmember = new Carmember();
				carmember.setCarmemberId(rs.getString("carmember_id"));
				carmember.setCarmemberPw(rs.getString("carmember_pw"));
				carmember.setCarmemberName(rs.getString("carmember_name"));
				carmember.setCarmemberCarnum(rs.getString("carmember_carnum"));
				carmember.setCarmemberCarname(rs.getString("carmember_carname"));
				carmember.setCarmemberEmail(rs.getString("carmember_email"));
				carmember.setCarmemberAddress(rs.getString("carmember_address"));
				list.add(carmember);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	public int updateCarnum(Carmember carmember) {
		int result = 0;
		try {
			conn();
			String sql = "update carmember set carmember_carnum = ? where carmember_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carmember.getCarmemberCarnum());
			pstmt.setString(2, carmember.getCarmemberId());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	public int updateCarname(Carmember carmember) {
		int result = 0;
		try {
			conn();
			String sql = "update carmember set carmember_carname = ? where carmember_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carmember.getCarmemberCarname());
			pstmt.setString(2, carmember.getCarmemberId());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	public int deleteCarmember(String carmemberId) {
		int result = 0;
		try {
			conn();
			String sql = "delete from carmember where carmember_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carmemberId);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
		
	}

}
