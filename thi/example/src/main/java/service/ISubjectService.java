package service;

import model.BaiHoc;
import model.Module;

import java.util.List;

public interface ISubjectService {
    List<BaiHoc> findAll();
    List<Module> findModule();
    void create(BaiHoc baiHoc);
    boolean deleteSubject(int id);
    void editSubject(int id, BaiHoc baiHoc);
    BaiHoc findById(int id);
}
