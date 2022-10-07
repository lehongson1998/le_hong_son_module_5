package service.impl;

import model.BaiHoc;
import model.Module;
import repository.impl.SubjectRepository;
import service.ISubjectService;

import java.util.List;

public class SubjectService implements ISubjectService {
    SubjectRepository subjectRepository = new SubjectRepository();
    @Override
    public List<BaiHoc> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public List<Module> findModule() {
        return subjectRepository.findModule();
    }

    @Override
    public void create(BaiHoc baiHoc) {

    }

    @Override
    public boolean deleteSubject(int id) {
        return subjectRepository.deleteSubject(id);
    }

    @Override
    public void editSubject(int id, BaiHoc baiHoc) {

    }

    @Override
    public BaiHoc findById(int id) {
        return null;
    }
}
