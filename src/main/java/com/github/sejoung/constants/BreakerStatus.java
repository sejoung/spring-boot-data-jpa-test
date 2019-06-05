package com.github.sejoung.constants;

import static java.util.stream.Collectors.toMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public enum BreakerStatus {

    RELAY_IN_OPEN("relayInOpen", "입구 열림 릴레이"),
    RELAY_OUT_OPEN("relayOutOpen", "출구 열림 릴레이"),
    RELAY_IN_CLOSE("relayInClose", "입구 닫힘 릴레이"),
    RELAY_OUT_CLOSE("relayOutClose", "출구 닫힘 릴레이");

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
