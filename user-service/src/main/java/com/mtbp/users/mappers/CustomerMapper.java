package com.mtbp.users.mappers;

import com.mtbp.commons.dto.users.AddCustomerRequest;
import com.mtbp.commons.dto.users.CustomerDto;
import com.mtbp.commons.dto.users.UpdateCustomerRequest;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.users.Customer;
import org.mapstruct.*;

@Mapper(
    componentModel = "spring",
    imports = {DocKeyUtils.class},
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface CustomerMapper {
    @Mapping(target = "id", expression = "java(DocKeyUtils.createCustomerDocKey())")
    Customer map(AddCustomerRequest addCustomerRequest);

    Customer map(@MappingTarget Customer customer, UpdateCustomerRequest updateCustomerRequest);

    @Mapping(target = "id", expression = "java(DocKeyUtils.removeDocPrefix(customer.getId()))")
    CustomerDto map(Customer customer);
}
