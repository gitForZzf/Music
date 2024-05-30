package com.zzf.music.platform.uid;

import java.util.List;

public interface IdGenService {

    String genOneId();

    List<String> genIds(int count);

}
