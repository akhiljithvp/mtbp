package com.mtbp.users.mappers;

import com.mtbp.commons.dto.users.AddPartnerRequest;
import com.mtbp.commons.dto.users.PartnerDto;
import com.mtbp.commons.dto.users.UpdatePartnerRequest;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.users.Partner;
import org.mapstruct.*;

@Mapper(
    componentModel = "spring",
    imports = {DocKeyUtils.class},
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface PartnerMapper {
    @Mapping(target = "id", expression = "java(DocKeyUtils.createPartnerDocKey())")
    Partner map(AddPartnerRequest addPartnerRequest);

    Partner map(@MappingTarget Partner partner, UpdatePartnerRequest updatePartnerRequest);

    @Mapping(target = "id", expression = "java(DocKeyUtils.removeDocPrefix(partner.getId()))")
    PartnerDto map(Partner partner);
}
