package service.impl;

import model.MatBang;
import repository.IMatBangRepos;
import repository.impl.MatBangRepos;
import service.IMatBangService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatBangService implements IMatBangService<MatBang> {
    private IMatBangRepos<MatBang>iMatBangRepos = new MatBangRepos();
    @Override
    public MatBang findById(int id) {
        return null;
    }

    @Override
    public Map<String, String> add(MatBang matBang) {
        Map<String, String> mapError = new HashMap<>();
        if (!matBang.getMa_mb().matches("^MB-\d{3}$")) {
            mapError.put("ma_mb", "MB must MB-XXX");
        }
        if(matBang.getGia() <10000){
            mapError.put("gia","gia must > 10000");
        }
        if (matBang.getDien_tich()<20){
            mapError.put("dien_tich","dien tich > 20");
        }
        if (mapError.isEmpty()) {
            iMatBangRepos.add(matBang);
        }
        return mapError;
    }

    @Override

    public boolean delete(String id) {
        return iMatBangRepos.delete(id);
    }

    @Override
    public boolean update(MatBang matBang) {
        return false;
    }

    @Override
    public List<MatBang> findByName(String name) {
        return null;
    }

    @Override
    public List<MatBang> findAll() {
        return iMatBangRepos.findAll();
    }
}
