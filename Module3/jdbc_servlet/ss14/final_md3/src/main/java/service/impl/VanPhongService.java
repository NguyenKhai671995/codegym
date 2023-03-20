package service.impl;

import model.VanPhong;
import repository.IVanPhongRepos;
import repository.impl.VanPhongRepos;
import service.IVanPhongService;

import java.util.List;

public class VanPhongService implements IVanPhongService<VanPhong> {
    private IVanPhongRepos<VanPhong> iVanPhongRepos = new VanPhongRepos();
    @Override
    public List<VanPhong> findAll() {
        return iVanPhongRepos.findAll();
    }
}
