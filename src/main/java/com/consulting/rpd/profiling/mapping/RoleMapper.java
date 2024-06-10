package com.consulting.rpd.profiling.mapping;

import com.consulting.rpd.profiling.domain.model.Role;
import com.consulting.rpd.profiling.resource.CreateRoleResource;
import com.consulting.rpd.profiling.resource.RoleResource;
import com.consulting.rpd.profiling.resource.UpdateRoleResource;
import com.consulting.rpd.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RoleMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public RoleResource toResource(Role model) {return mapper.map(model, RoleResource.class);}

    public Role toModel(CreateRoleResource resource) {return mapper.map(resource, Role.class);}

    public Role toModel(UpdateRoleResource resource) {return mapper.map(resource, Role.class);}

    public Page<RoleResource> modelListPage(List<Role> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList,RoleResource.class),pageable,modelList.size());
    }
}
