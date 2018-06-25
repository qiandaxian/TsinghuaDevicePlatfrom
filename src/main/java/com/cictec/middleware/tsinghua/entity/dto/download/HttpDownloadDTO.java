package com.cictec.middleware.tsinghua.entity.dto.download;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpDownloadDTO {
    private String url;
    private String savePath;
    private short saveModel;
    private String mediaUuid;
}
