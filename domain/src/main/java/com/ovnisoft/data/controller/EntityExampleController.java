package com.ovnisoft.data.controller;

import com.ovnisoft.data.entity.EntityExample;
import com.ovnisoft.data.request.CustomResponse;

public interface EntityExampleController {
    boolean saveEntityExample(EntityExample entityExample);

    CustomResponse<EntityExample> getEntityExample(EntityExample entityExample);

    boolean updateEntityExample(EntityExample entityExample);

    boolean deleteEntityExample(EntityExample entityExample);
}
