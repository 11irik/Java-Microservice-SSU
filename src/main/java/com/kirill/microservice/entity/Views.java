package com.kirill.microservice.entity;

public final class Views {
    public interface Id {}

    public interface IdName extends Id {}

    public interface Mid extends IdName {}

    public interface Full extends Mid {}
}
