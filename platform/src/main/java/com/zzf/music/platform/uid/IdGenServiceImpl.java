package com.zzf.music.platform.uid;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IdGenServiceImpl implements IdGenService{

    SnowflakeIdGenerator idGenerator = new SnowflakeIdGenerator(1,1);

    @Override
    public String genOneId() {

        return  Long.toHexString(idGenerator.nextId());
    }

    @Override
    public List<String> genIds(int count) {

        List<String> idList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            long id = idGenerator.nextId();
            String hexString = Long.toHexString(id);
            idList.add(hexString);
        }
        return idList;
    }
}
