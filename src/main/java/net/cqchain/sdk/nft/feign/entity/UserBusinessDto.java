package net.cqchain.sdk.nft.feign.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserBusinessDto {
    // 用户名
    @NotBlank(message = "用户名不能为空")
    private String username;

    // 用户描述
    private String userDesc;

    // 企业名称
    @NotBlank(message = "企业名称不能为空")
    private String epName;

    // 企业LOGO
    private String logo;

    // 企业简介
    private String description;

    // 邮箱
    @Email(message = "邮箱格式错误")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    // 企业信用代码
    @NotBlank(message = "企业信用代码不能为空")
    private String creditCode;

    // 营业执照文件
    @NotBlank(message = "营业执照文件不能为空")
    private String busiLicenseUrl;

    // 法人代表姓名
    @NotBlank(message = "法人代表姓名不能为空")
    private String representativeName;

    // 管理员姓名
    @NotBlank(message = "管理员姓名不能为空")
    private String contact;

    // 管理员手机
    @NotBlank(message = "管理员手机不能为空")
    private String mobile;

    // 管理员身份证号
    @NotBlank(message = "管理员身份证号不能为空")
    private String idcard;

    // 证件类型：1-身份证2-护照3-港澳通行证4-台湾通行证5-外国人永居身份证6-港澳台居民居住证7-其他
    @NotNull(message = "证件类型不能为空")
    private Integer cardType;

    // 电子公函盖章扫描件
    @NotBlank(message = "电子公函盖章扫描件不能为空")
    private String officialLetterUrl;
}
