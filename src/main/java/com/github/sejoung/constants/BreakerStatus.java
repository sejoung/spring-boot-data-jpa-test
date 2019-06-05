package com.github.sejoung.constants;

import static java.util.stream.Collectors.toMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public enum BreakerStatus {

    RELAY_IN_OPEN("relayInOpen", "입구 안열림"),
    RELAY_OUT_OPEN("relayOutOpen", "출구 안열림"),
    RELAY_IN_CLOSE("relayInClose", "입구 안닫힘"),
    RELAY_OUT_CLOSE("relayOutClose", "출구 안닫힘"),
    TRY_1_PASS("try1Pass", "한번에 성공"),
    TRY_2_PASS("try2Pass", "두번에 성공"),
    TRY_3_PASS("try3Pass", "세번에 성공"),
    TRY_4_PASS("try4Pass", "네번에 성공");

    private static final Map<String, BreakerStatus> stringToEnum =
        Stream.of(values()).collect(toMap(Objects::toString, e -> e));

    private String code;

    private String desc;

    BreakerStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @JsonCreator
    public static BreakerStatus fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
