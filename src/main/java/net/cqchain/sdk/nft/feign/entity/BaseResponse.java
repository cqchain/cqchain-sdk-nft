package net.cqchain.sdk.nft.feign.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> implements Serializable {
    // 状态码
    private int code;

    // 信息
    private String message;

    // 数据
    private T data;
}
