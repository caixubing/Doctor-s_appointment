package com.cxb.drapp.service.impl;

        import com.cxb.drapp.mapper.ReserinfoMapper;
        import com.cxb.drapp.pojo.Reserinfo;
        import com.cxb.drapp.service.ReserinfoService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class ReserinfoServiceImpl implements ReserinfoService {
    @Autowired
    ReserinfoMapper reserinfoMapper;

    @Override
    public int update(Reserinfo reserinfo) {
        return reserinfoMapper.updateByPrimaryKey(reserinfo);
    }

    @Override
    public void add(Reserinfo reserinfo) {
        reserinfoMapper.insert(reserinfo);
    }


    @Override
    public List<Reserinfo> patientlist( Reserinfo reserinfo) {
        return reserinfoMapper.patientlist(reserinfo);
    }

    @Override
    public List<Reserinfo> doctorlist(Reserinfo reserinfo) {
        return reserinfoMapper.doctorlist(reserinfo);
    }

    @Override
    public List<Reserinfo> doctorlist_ok(Reserinfo reserinfo) {
        return reserinfoMapper.doctorlist_ok(reserinfo);
    }
}
