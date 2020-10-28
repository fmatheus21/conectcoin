package com.firecode.app.controller.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PathUtil {

    @Getter
    @Value("${dir.static}")
    private String dirStatic;

    @Getter
    @Value("${dir.upload}")
    private String dirUpload;

    @Getter
    @Value("${dir.avatar}")
    private String dirAvatar;

    @Getter
    @Value("${dir.logo}")
    private String dirLogo;

    @Getter
    @Value("${dir.avatar.system}")
    private String dirAvatarSystem;

    @Getter
    @Value("${extension.image}")
    private String extensionImage;

    @Getter
    @Value("${mail.system}")
    private String mailSystem;

    @Getter
    @Value("${mail.system.destination}")
    private String mailSystemDestination;

    @Getter
    @Value("${file.size.total}")
    private long fileSizeTotal;

    public String localPath() {
        // return System.getProperty("user.dir");
        return getClass().getClassLoader().getResource("").getPath().replace("%20", " ");
    }

}
