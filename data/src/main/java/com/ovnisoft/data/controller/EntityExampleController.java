package com.ovnisoft.data.controller;

import com.ovnisoft.data.callbacks.Callback;
import com.ovnisoft.data.entity.EntityExample;
import com.ovnisoft.data.errors.RequestError;
import com.ovnisoft.data.requests.RequestUrls;
import com.ovnisoft.data.requests.ServerRequest;

public class EntityExampleController {

    private ServerRequest<EntityExample> mEntityExampleServerRequest;

    public EntityExampleController(ServerRequest<EntityExample> entityExampleServerRequest) {
        mEntityExampleServerRequest = entityExampleServerRequest;
    }

    public void saveEntityExample(EntityExample entityExample) {
        mEntityExampleServerRequest.request(ServerRequest.type.POST, RequestUrls.POST_ENTITY_EXAMPLE, entityExample, new Callback<EntityExample>() {
            @Override
            public void onResponse(EntityExample response) {

            }

            @Override
            public void onFailure(RequestError error) {

            }
        });
    }

    public void getEntityExample(EntityExample entityExample) {
        final String url = RequestUrls.GET_ENTITY_EXAMPLE + entityExample.getUserId();
        mEntityExampleServerRequest.request(ServerRequest.type.GET, url, new Callback<EntityExample>() {
            @Override
            public void onResponse(EntityExample response) {

            }

            @Override
            public void onFailure(RequestError error) {

            }
        });
    }

    public void updateEntityExample(EntityExample entityExample) {
        final String url = RequestUrls.GET_ENTITY_EXAMPLE + entityExample.getUserId();
        mEntityExampleServerRequest.request(ServerRequest.type.PUT, url, entityExample, new Callback<EntityExample>() {
            @Override
            public void onResponse(EntityExample response) {

            }

            @Override
            public void onFailure(RequestError error) {

            }
        });
    }

    public void deleteEntityExample(EntityExample entityExample) {
        final String url = RequestUrls.GET_ENTITY_EXAMPLE + entityExample.getUserId();
        mEntityExampleServerRequest.request(ServerRequest.type.DELETE, url, new Callback<EntityExample>() {
            @Override
            public void onResponse(EntityExample response) {

            }

            @Override
            public void onFailure(RequestError error) {

            }
        });
    }

}
