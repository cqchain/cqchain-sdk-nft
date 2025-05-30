package net.cqchain.sdk.nft.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.cqchain.sdk.nft.feign.entity.UserBusinessDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateBusinessUserBo extends UserBusinessDto {
}
