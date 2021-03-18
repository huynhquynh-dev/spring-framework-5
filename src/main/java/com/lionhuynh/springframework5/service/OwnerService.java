package com.lionhuynh.springframework5.service;

import com.lionhuynh.springframework5.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
