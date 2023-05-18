package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.ItemGroup;
import configuration.DbConnection;
import util.SqlUtils;

public class JdbcItemGroupDao implements ItemGroupDao {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst; // value

	public JdbcItemGroupDao() {
		conn = DbConnection.getConnection();
	}

	@Override
	public List<ItemGroup> getAll() {
		List<ItemGroup> result = new ArrayList<>();
		// B1: Write down sql statement
		String sql = "SELECT 	ID, " + ItemGroup.PROP_ID + ",\n" + "			`NAME`," + ItemGroup.PROP_NAME + ",\n"
				+ "			`DESC`" + ItemGroup.PROP_DESC + "\n" + "FROM ITEM_GROUP";

		try {
			st = conn.createStatement();
			// rs chứa dữ liệu vừa thực thi xong
			rs = st.executeQuery(sql); // bắn service thực thi cho mình

			// Duyệt từng dòng
			while (rs.next()) {
				// transformer
				ItemGroup ig = transformer(rs);
				result.add(ig);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}

	@Override
	public void save(ItemGroup ig) {
		String sql = "INSERT INTO ITEM_GROUP(ID, `NAME`, `DESC`)\n" + "VALUE(?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, ig.getId());
			pst.setString(2, ig.getName());
			pst.setString(3, ig.getDescription());
			pst.executeUpdate();// thực thi
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst);
		}
	}

	@Override
	public void update(ItemGroup ig) {
		String sql = "UPDATE ITEM_GROUP\n" + "	SET `NAME` = ?, \n" + "	 	`DESC` = ?" + " WHERE ID  = 	?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, ig.getName());
			pst.setString(2, ig.getDescription());
			pst.setInt(3, ig.getId());
			pst.executeUpdate();// thực thi
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ItemGroup get(int id) {
		// B1: Write down sql statement
		String sql = "SELECT ID, " + ItemGroup.PROP_ID + ",\n" + "		`NAME`," + ItemGroup.PROP_NAME + ",\n"
				+ "		`DESC`" + ItemGroup.PROP_DESC + "\n " + "FROM ITEM_GROUP\n" + "WHERE ID =" + id;
		ItemGroup result = null;
		try {
			st = conn.createStatement();
			// rs chứa dữ liệu vừa thực thi xong
			rs = st.executeQuery(sql); // bắn service thực thi cho mình

			// Duyệt 1 dòng
			if (rs.next()) {
				// transformer
				result = transformer(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}

	@Override
	public ItemGroup get(String name) {
		// B1: Write down sql statement
//		 Lưu ý lỗi name
		String sql = "SELECT ID, " + ItemGroup.PROP_ID + ",\n" + "		`NAME`," + ItemGroup.PROP_NAME + ",\n"
				+ "		`DESC`" + ItemGroup.PROP_DESC + "\n " + "FROM ITEM_GROUP\n" + "WHERE `NAME` = '" + name + "'";
		ItemGroup result = null;
		try {
			st = conn.createStatement();
			// rs chứa dữ liệu vừa thực thi xong
			rs = st.executeQuery(sql); // bắn service thực thi cho mình

			// Duyệt 1 dòng
			if (rs.next()) {
				// transformer
				result = transformer(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}
	
	public static ItemGroup transformer(ResultSet rs) throws SQLException {
		return new ItemGroup(rs.getInt(ItemGroup.PROP_ID), rs.getString(ItemGroup.PROP_NAME),
				rs.getString(ItemGroup.PROP_DESC));
	}

}
