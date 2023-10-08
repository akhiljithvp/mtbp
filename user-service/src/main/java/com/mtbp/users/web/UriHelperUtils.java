package com.mtbp.users.web;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class UriHelperUtils {

    public static URI createUriFrom(Class clazz, Object... paths) {
        UriComponentsBuilder builder = WebMvcLinkBuilder.linkTo(clazz).toUriComponentsBuilder();
        for (Object path : paths) {
            builder.pathSegment((String) path);
        }
        return builder.build().toUri();
    }
}