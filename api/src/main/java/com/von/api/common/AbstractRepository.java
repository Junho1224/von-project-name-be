package com.von.api.common;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractRepository {


    public abstract Map<String, ?> bugsSave(Map<String, ?>paraMap) throws IOException;

    public abstract Map<String, ?> melonSave(Map<String, ?> paraMap) throws IOException;

}
