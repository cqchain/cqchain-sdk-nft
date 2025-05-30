package net.cqchain.sdk.nft.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.cqchain.sdk.nft.feign.entity.UserDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateUserBo extends UserDto {
}
