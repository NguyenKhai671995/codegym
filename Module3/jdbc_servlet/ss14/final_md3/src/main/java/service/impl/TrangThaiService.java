package service.impl;

import model.TrangThai;
import repository.ITrangThaiRepos;
import repository.impl.TrangThaiRepos;
import service.ITrangThaiService;

import java.util.List;

public class TrangThaiService implements ITrangThaiService<TrangThai> {
    private ITrangThaiRepos<TrangThai>iTrangThaiRepos = new TrangThaiRepos();
    @Override
    public List<TrangThai> findAll() {
        return iTrangThaiRepos.findAll();
    }
}
