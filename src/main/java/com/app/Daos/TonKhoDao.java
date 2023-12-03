package com.app.Daos;

import com.app.Entitys.TonKho;
import com.app.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TonKhoDao implements DaoMain<TonKho, Integer> {

    @Override
    public void insert(TonKho entity) {
        String query = "INSERT INTO tonkho (makho, masp, soluong) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(query,
                entity.getMaKho(),
                entity.getMasp(),
                entity.getSoluong());
    }

    @Override
    public void update(TonKho entity) {
        String query = "UPDATE tonkho SET soluong = ? WHERE makho = ? AND masp = ?";
        JdbcHelper.executeUpdate(query,
                entity.getSoluong(),
                entity.getMaKho(),
                entity.getMasp());
    }

    @Override
    public void delete(Integer key) {
        String query = "DELETE FROM tonkho WHERE Matonkho = ?";
        JdbcHelper.executeUpdate(query, key);
    }

    @Override
    public List<TonKho> selectAll() {
        List<TonKho> tonKhoList = new ArrayList<>();
        String query = "SELECT * FROM tonkho";
        try (ResultSet resultSet = JdbcHelper.executeQuery(query)) {
            while (resultSet.next()) {
                TonKho tonKho = readFromResultSet(resultSet);
                tonKhoList.add(tonKho);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tonKhoList;
    }

    @Override
    public TonKho selectById(Integer key) {
        TonKho tonKho = null;
        String query = "SELECT * FROM tonkho WHERE Matonkho = ?";
        try (ResultSet resultSet = JdbcHelper.executeQuery(query, key)) {
            if (resultSet.next()) {
                tonKho = readFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tonKho;
    }
    
    public List<Object[]> getThongSoKho() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call dbo.ThongSoKho}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getInt("TongNhap"),
                        rs.getInt("TongXuat"),
                        rs.getInt("TongSanPham"),
                        rs.getInt("TongSoLuongSanPham")
                    };
                    list.add(model);

                }
            } finally {
                rs.getStatement().getConnection().close();

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }
        return list;

    }
    
       public void updateSoLuong(TonKho entity) {
        String query = "UPDATE tonkho SET soluong = ? WHERE masp = ?";
        JdbcHelper.executeUpdate(query,
                entity.getSoluong(),
                entity.getMasp());
    }
    
    public TonKho selectByIdSanPham(String key) {
        TonKho tonKho = null;
        String query = "SELECT * FROM tonkho WHERE masp = ?";
        try (ResultSet resultSet = JdbcHelper.executeQuery(query, key)) {
            if (resultSet.next()) {
                tonKho = readFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tonKho;
    }

    @Override
    public List<TonKho> selectBySql(String sql, Object... args) {
        List<TonKho> tonKhoList = new ArrayList<>();
        try (ResultSet resultSet = JdbcHelper.executeQuery(sql, args)) {
            while (resultSet.next()) {
                TonKho tonKho = readFromResultSet(resultSet);
                tonKhoList.add(tonKho);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tonKhoList;
    }

    private TonKho readFromResultSet(ResultSet resultSet) throws SQLException {
        TonKho tonKho = new TonKho();
        tonKho.setMaTonKho(resultSet.getInt("Matonkho"));
        tonKho.setMaKho(resultSet.getString("makho"));
        tonKho.setMasp(resultSet.getString("masp"));
        tonKho.setSoluong(resultSet.getInt("soluong"));
        return tonKho;
    }

  
}
