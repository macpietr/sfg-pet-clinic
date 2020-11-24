package com.matthausitberatung.sfgpetclinic.services;

import com.matthausitberatung.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
