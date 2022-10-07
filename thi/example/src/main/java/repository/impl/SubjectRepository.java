package repository.impl;

import connect.DataBaseConnect;
import model.BaiHoc;
import model.Module;
import repository.ISubjectRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectRepository implements ISubjectRepository {
    private final String FIND_ALL = "SELECT * FROM bai_hoc;";
    private final String FIND_MODULE = "SELECT * FROM module";
    private final String DELETE_SUBJECT = "CALL delete_bai_hoc(?);";
    @Override
    public List<BaiHoc> findAll() {
        List<BaiHoc> baiHocList = new ArrayList<>();
        BaiHoc baiHoc;
        Connection connection = DataBaseConnect.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int maBaiHoc = rs.getInt("ma_bai_hoc");
                int maModule = rs.getInt("ma_module");
                String tieuDe = rs.getString("tieu_de");
                String loaiBaiHoc = rs.getString("loai_bai_hoc");
                String doKho = rs.getString("do_kho");
                String link = rs.getString("link_bai_hoc");
                baiHoc = new BaiHoc(maBaiHoc, maModule, tieuDe, loaiBaiHoc, doKho, link);
                baiHocList.add(baiHoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return baiHocList;
    }

    @Override
    public List<Module> findModule() {
        List<Module> moduleList = new ArrayList<>();
        Module module;
        Connection connection = DataBaseConnect.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_MODULE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int maModule = rs.getInt("ma_module");
                String tenModule = rs.getString("ten_module");
                module = new Module(maModule, tenModule);
                moduleList.add(module);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moduleList;
    }

    @Override
    public void create(BaiHoc baiHoc) {

    }

    @Override
    public boolean deleteSubject(int id) {
        Connection connection = DataBaseConnect.getConnectDB();
        int check;
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_SUBJECT);
            callableStatement.setInt(1, id);
            check = callableStatement.executeUpdate();
            return check > 0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void editSubject(int id, BaiHoc baiHoc) {

    }

    @Override
    public BaiHoc findById(int id) {
        return null;
    }
}
