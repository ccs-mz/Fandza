package com.fandza.ccs.Fandza.config.uuid;

import com.github.f4b6a3.uuid.UuidCreator;

import java.util.UUID;

public class UuidV7Generator {
    public static UUID generateUuid(){
        return UuidCreator.getTimeOrderedEpoch();
    }
}
