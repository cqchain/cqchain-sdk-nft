package net.cqchain.sdk.nft.feign.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {
    // 用户名
    @NotBlank(message = "用户名不能为空")
    private String username;

    // 用户描述
    private String description;

    // 姓名
    @NotBlank(message = "姓名不能为空")
    private String personName;

    // 证件号
    @NotBlank(message = "证件号不能为空")
    private String idcard;

    // 证件类型：1-身份证2-护照3-港澳通行证4-台湾通行证5-外国人永居身份证6-港澳台居民居住证7-其他
    @NotNull(message = "证件类型不能为空")
    private Integer cardType;
}
