package com.ovnisoft.data.controller;

import com.ovnisoft.data.entity.EntityExample;
import com.ovnisoft.data.request.CustomResponse;
import com.ovnisoft.data.request.ResponseCodes;
import com.ovnisoft.data.requests.RequestUrls;
import com.ovnisoft.data.requests.ServerRequest;

public class EntityExampleControllerImpl implements EntityExampleController {

    private ServerRequest<EntityExample> mEntityExampleServerRequest;

    public EntityExampleControllerImpl(ServerRequest<EntityExample> entityExampleServerRequest) {
        mEntityExampleServerRequest = entityExampleServerRequest;
    }

    @Override
    public boolean saveEntityExample(EntityExample entityExample) {
        CustomResponse<EntityExample> customResponse =
                mEntityExampleServerRequest.postRequest(RequestUrls.POST_ENTITY_EXAMPLE, entityExample);

        return customResponse.getCode() == ResponseCodes.CREATED;
    }

    @Override
    public CustomResponse<EntityExample> getEntityExample(EntityExample entityExample) {
        return mEntityExampleServerRequest.getRequest(
                RequestUrls.GET_ENTITY_EXAMPLE + entityExample.getUserId()
        );
    }

    @Override
    public boolean updateEntityExample(EntityExample entityExample) {
        CustomResponse<EntityExample> customResponse =
                mEntityExampleServerRequest.postRequest(RequestUrls.POST_ENTITY_EXAMPLE, entityExample);

        return customResponse.getCode() == ResponseCodes.OK;
    }

    @Override
    public boolean deleteEntityExample(EntityExample entityExample) {
        CustomResponse<EntityExample> customResponse =
                mEntityExampleServerRequest.postRequest(RequestUrls.POST_ENTITY_EXAMPLE, entityExample);

        return customResponse.getCode() == ResponseCodes.OK;
    }

}
